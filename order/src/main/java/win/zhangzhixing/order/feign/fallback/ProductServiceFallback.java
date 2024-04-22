package win.zhangzhixing.order.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import win.zhangzhixing.order.feign.IProductService;

@Component
@Slf4j
public class ProductServiceFallback implements IProductService {
    @Override
    public JSONObject get(String id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("price", null);
        log.error(String.format("ProductServiceFallback.get(%s)", id));
        return jsonObject;
    }

    @Override
    public JSONObject deStock(String id, JSONObject product) {
        JSONObject jsonObject = new JSONObject();
        log.error(String.format("ProductServiceFallback.deStock(%s, %s)", id, product));
        return jsonObject;
    }
}