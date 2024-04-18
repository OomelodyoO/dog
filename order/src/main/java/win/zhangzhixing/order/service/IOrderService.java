package win.zhangzhixing.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import win.zhangzhixing.order.model.Order;
import win.zhangzhixing.order.response.BoolResp;
import win.zhangzhixing.order.response.OrderResp;

import java.math.BigDecimal;
import java.util.Date;

public interface IOrderService {

    OrderResp create(Order order);

    OrderResp update(Integer id, Order nOrder);

    BoolResp delete(Integer id);

    OrderResp get(Integer id);

    Page<OrderResp> query(String userId, String productId, Integer status, Date startOrderTime, Date endOrderTime, BigDecimal totalAmount, Page<OrderResp> page);
}
