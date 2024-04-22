package win.zhangzhixing.order.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import win.zhangzhixing.order.feign.fallback.ProductServiceFallback;

@FeignClient(value = "product", fallback = ProductServiceFallback.class)
public interface IProductService {
    @GetMapping(value = "/product/{id}")
    JSONObject get(@PathVariable("id") String id);

    @PutMapping(value = "/product/deStock/{id}")
    JSONObject deStock(@PathVariable("id") String id, @RequestBody JSONObject product);
}
