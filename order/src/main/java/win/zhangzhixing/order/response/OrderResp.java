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
    private String id;
    private String userId;
    private String productId;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Date createTime;
    private BigDecimal totalAmount;
    private Integer qty;

    public OrderResp(Order order) {
        setId(order.getId());
        setUserId(order.getUserId());
        setProductId(order.getProductId());
        setStatus(order.getStatus());
        setCreateTime(order.getCreateTime());
        setTotalAmount(order.getTotalAmount());
        setQty(order.getQty());
    }
}
