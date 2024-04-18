package win.zhangzhixing.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import win.zhangzhixing.order.model.Order;
import win.zhangzhixing.order.response.BoolResp;
import win.zhangzhixing.order.response.OrderResp;
import win.zhangzhixing.order.service.IOrderService;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResp create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @DeleteMapping(value = "/{id}")
    public BoolResp delete(@PathVariable Integer id) {
        return orderService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public OrderResp update(@PathVariable Integer id, @RequestBody Order nOrder) {
        return orderService.update(id, nOrder);
    }

    @GetMapping(value = "/{id}")
    public OrderResp get(@PathVariable Integer id) {
        return orderService.get(id);
    }

    @GetMapping
    public Page<OrderResp> query(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "productId", required = false) String productId,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "startOrderTime", required = false) Long startOrderTime,
            @RequestParam(value = "endOrderTime", required = false) Long endOrderTime,
            @RequestParam(value = "totalAmount", required = false) BigDecimal totalAmount,
            @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    ) {
        return orderService.query(
                userId,
                productId,
                status,
                ObjectUtils.isEmpty(startOrderTime) ? null : new Date(startOrderTime),
                ObjectUtils.isEmpty(endOrderTime) ? null : new Date(endOrderTime),
                totalAmount,
                new Page<>(current, size)
        );
    }
}
