package win.zhangzhixing.product.service.impl;

import com.alibaba.nacos.common.utils.UuidUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import win.zhangzhixing.product.mapper.ProductMapper;
import win.zhangzhixing.product.model.Product;
import win.zhangzhixing.product.request.DeStockReq;
import win.zhangzhixing.product.response.BoolResp;
import win.zhangzhixing.product.response.ProductResp;
import win.zhangzhixing.product.service.IProductService;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    private final ProductMapper productMapper;
    private final RedissonClient redissonClient;

    public ProductServiceImpl(ProductMapper productMapper, RedissonClient redissonClient) {
        this.productMapper = productMapper;
        this.redissonClient = redissonClient;
    }

    @Override
    public ProductResp create(Product product) {
        product.setId(UuidUtils.generateUuid());
        product.setCreateTime(new Date());
        productMapper.insert(product);
        return new ProductResp(productMapper.selectById(product.getId()));
    }

    @Override
    public BoolResp delete(String id) {
        productMapper.deleteById(id);
        return new BoolResp(true);
    }

    @Override
    public ProductResp update(String id, Product nProduct) {
        nProduct.setId(id);
        productMapper.updateById(nProduct);
        return new ProductResp(productMapper.selectById(id));
    }

    @Override
    public ProductResp get(String id) {
        return new ProductResp(productMapper.selectById(id));
    }

    @Override
    public Page<ProductResp> query(String name, String description, Date startCreateTime, Date endCreateTime, Page<ProductResp> page) {
        return productMapper.query(name, description, startCreateTime, endCreateTime, page);
    }

    @Override
    public ProductResp deStock(String id, DeStockReq deStockReq) {
        RLock lock = redissonClient.getLock("product:" + id);
        Product product = null;
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                product = productMapper.selectById(id);
                log.info(String.format("线程%s获得商品%s的锁", Thread.currentThread().getName(), id));
                if (product.getQty() - deStockReq.getQty() >= 0) {
                    product.setQty(product.getQty() - deStockReq.getQty());
                    productMapper.updateById(product);
                } else {
                    throw new RuntimeException("库存不足");
                }
            } else {
                throw new RuntimeException(String.format("线程%s获得商品%s的锁失败", Thread.currentThread().getName(), id));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
                log.info(String.format("线程%s释放商品%s的锁", Thread.currentThread().getName(), id));
            }
        }
        log.info(String.format("商品ID：%s 名称：%s 剩余库存：%s", product.getId(), product.getName(), product.getQty()));
        return new ProductResp(product);
    }
}