package win.zhangzhixing.order.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import win.zhangzhixing.order.feign.IProductService;

@Component
public class ProductServiceFallback implements IProductService {
    @Override
    public JSONObject update(String id, JSONObject product) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", String.format("服务降级 ProductServiceFallback.update 记录数据%s", product));
        return jsonObject;
    }
}