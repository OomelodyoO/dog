package win.zhangzhixing.product.service.impl;

import com.alibaba.nacos.common.utils.UuidUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import win.zhangzhixing.product.mapper.ProductMapper;
import win.zhangzhixing.product.model.Product;
import win.zhangzhixing.product.response.BoolResp;
import win.zhangzhixing.product.response.ProductResp;
import win.zhangzhixing.product.service.IProductService;

import java.util.Date;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
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
}