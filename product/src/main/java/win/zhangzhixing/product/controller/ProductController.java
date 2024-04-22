package win.zhangzhixing.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import win.zhangzhixing.product.model.Product;
import win.zhangzhixing.product.request.DeStockReq;
import win.zhangzhixing.product.response.BoolResp;
import win.zhangzhixing.product.response.ProductResp;
import win.zhangzhixing.product.service.IProductService;

import java.util.Date;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResp create(@RequestBody Product product) {
        return productService.create(product);
    }

    @DeleteMapping(value = "/{id}")
    public BoolResp delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public ProductResp update(@PathVariable String id, @RequestBody Product nProduct) {
        return productService.update(id, nProduct);
    }

    @GetMapping(value = "/{id}")
    public ProductResp get(@PathVariable String id) {
        return productService.get(id);
    }

    @GetMapping
    public Page<ProductResp> query(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "startCreateTimestamp", required = false) Long startCreateTimestamp,
            @RequestParam(value = "endCreateTimestamp", required = false) Long endCreateTimestamp,
            @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    ) {
        return productService.query(
                name,
                description,
                ObjectUtils.isEmpty(startCreateTimestamp) ? null : new Date(startCreateTimestamp),
                ObjectUtils.isEmpty(endCreateTimestamp) ? null : new Date(endCreateTimestamp),
                new Page<>(current, size)
        );
    }

    @PutMapping(value = "/deStock/{id}")
    public ProductResp deStock(@PathVariable String id, @RequestBody DeStockReq deStockReq) {
        return productService.deStock(id, deStockReq);
    }
}
