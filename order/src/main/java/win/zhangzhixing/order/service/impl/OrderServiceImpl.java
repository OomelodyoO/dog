package win.zhangzhixing.order.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import win.zhangzhixing.order.mapper.OrderMapper;
import win.zhangzhixing.order.model.Order;
import win.zhangzhixing.order.response.BoolResp;
import win.zhangzhixing.order.response.OrderResp;
import win.zhangzhixing.order.service.IOrderService;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResp create(Order order) {
        order.setOrderTime(new Date());
        orderMapper.insert(order);
        return new OrderResp(orderMapper.selectById(order.getId()));
    }

    @Override
    public BoolResp delete(Integer id) {
        orderMapper.deleteById(id);
        return new BoolResp(true);
    }

    @Override
    public OrderResp update(Integer id, Order nOrder) {
        nOrder.setId(id);
        orderMapper.updateById(nOrder);
        return new OrderResp(orderMapper.selectById(id));
    }

    @Override
    public OrderResp get(Integer id) {
        return new OrderResp(orderMapper.selectById(id));
    }

    @Override
    public Page<OrderResp> query(String userId, String productId, Integer status, Date startOrderTime, Date endOrderTime, BigDecimal totalAmount, Page<OrderResp> page) {
        return orderMapper.query(userId, productId, status, startOrderTime, endOrderTime, totalAmount, page);
    }
}