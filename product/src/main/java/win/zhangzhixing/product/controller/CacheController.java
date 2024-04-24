package win.zhangzhixing.product.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.zhangzhixing.product.response.BoolResp;
import win.zhangzhixing.product.service.ICacheService;

@RestController
@RequestMapping(value = "/cache")
public class CacheController {
    private final ICacheService cacheService;

    public CacheController(ICacheService cacheService) {
        this.cacheService = cacheService;
    }


    @PostMapping
    public BoolResp create(@RequestBody JSONObject jsonObject) {
        return cacheService.set(jsonObject);
    }
}
