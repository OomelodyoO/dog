package win.zhangzhixing.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import win.zhangzhixing.product.model.Product;
import win.zhangzhixing.product.request.DeStockReq;
import win.zhangzhixing.product.response.BoolResp;
import win.zhangzhixing.product.response.ProductResp;

import java.util.Date;

public interface IProductService {

    ProductResp create(Product product);

    BoolResp delete(String id);

    ProductResp update(String id, Product nProduct);

    ProductResp get(String id);

    Page<ProductResp> query(String name, String description, Date startCreateTime, Date endCreateTime, Page<ProductResp> page);

    ProductResp deStock(String id, DeStockReq deStockReq);
}
