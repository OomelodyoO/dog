package win.zhangzhixing.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.UuidUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import win.zhangzhixing.order.feign.IProductService;
import win.zhangzhixing.order.mapper.OrderMapper;
import win.zhangzhixing.order.model.Order;
import win.zhangzhixing.order.response.BoolResp;
import win.zhangzhixing.order.response.OrderResp;
import win.zhangzhixing.order.service.IOrderService;

import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderMapper orderMapper;
    private final IProductService productService;

    public OrderServiceImpl(OrderMapper orderMapper, IProductService productService) {
        this.orderMapper = orderMapper;
        this.productService = productService;
    }

    @Override
    public OrderResp create(Order order) {
        order.setId(UuidUtils.generateUuid());
        order.setCreateTime(new Date());
        orderMapper.insert(order);
        // 减库存
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qty", order.getQty());
        System.out.println(productService.update(order.getProductId(), jsonObject));
        return new OrderResp(orderMapper.selectById(order.getId()));
    }

    @Override
    public BoolResp delete(String id) {
        orderMapper.deleteById(id);
        return new BoolResp(true);
    }

    @Override
    public OrderResp update(String id, Order nOrder) {
        nOrder.setId(id);
        orderMapper.updateById(nOrder);
        return new OrderResp(orderMapper.selectById(id));
    }

    @Override
    public OrderResp get(String id) {
        return new OrderResp(orderMapper.selectById(id));
    }

    @Override
    public Page<OrderResp> query(String userId, String productId, String status, Date startCreateTime, Date endCreateTime, Page<OrderResp> page) {
        return orderMapper.query(userId, productId, status, startCreateTime, endCreateTime, page);
    }
}