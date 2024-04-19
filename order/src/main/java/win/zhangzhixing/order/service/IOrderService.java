package win.zhangzhixing.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import win.zhangzhixing.order.model.Order;
import win.zhangzhixing.order.response.BoolResp;
import win.zhangzhixing.order.response.OrderResp;

import java.util.Date;

public interface IOrderService {

    OrderResp create(Order order);

    BoolResp delete(String id);

    OrderResp update(String id, Order nOrder);

    OrderResp get(String id);

    Page<OrderResp> query(String userId, String productId, String status, Date startCreateTime, Date endCreateTime, Page<OrderResp> page);
}
