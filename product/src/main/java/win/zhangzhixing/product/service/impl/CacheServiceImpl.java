package win.zhangzhixing.product.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import win.zhangzhixing.product.response.BoolResp;
import win.zhangzhixing.product.service.ICacheService;

@Service
@Slf4j
public class CacheServiceImpl implements ICacheService {
    private final RedisTemplate<String, Object> redisTemplate;

    public CacheServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public BoolResp set(JSONObject jsonObject) {
        redisTemplate.opsForValue().set(jsonObject.getString("key"), jsonObject);
        return new BoolResp(true);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
