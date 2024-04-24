package win.zhangzhixing.product.service;

import com.alibaba.fastjson.JSONObject;
import win.zhangzhixing.product.response.BoolResp;

public interface ICacheService {
    BoolResp set(JSONObject jsonObject);
}
