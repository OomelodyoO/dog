package win.zhangzhixing.order.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import win.zhangzhixing.order.model.Order;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrderResp {
    private Integer id;
    private String userId;
    private String productId;
    private Integer status;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Date orderTime;
    private BigDecimal totalAmount;

    public OrderResp(Order order) {
        setId(order.getId());
        setUserId(order.getUserId());
        setProductId(order.getProductId());
        setStatus(order.getStatus());
        setOrderTime(order.getOrderTime());
        setTotalAmount(order.getTotalAmount());
    }
}
