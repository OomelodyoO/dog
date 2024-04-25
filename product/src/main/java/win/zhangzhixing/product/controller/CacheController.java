package win.zhangzhixing.product.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/{key}")
    public Object get(@PathVariable String key) {
        return cacheService.get(key);
    }
}
