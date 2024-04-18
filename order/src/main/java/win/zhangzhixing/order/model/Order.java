package win.zhangzhixing.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "t_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "user_id")
    private String userId;
    @TableField(value = "product_id")
    private String productId;
    @TableField(value = "status")
    private Integer status;
    @TableField(value = "order_time")
    private Date orderTime;
    @TableField(value = "total_amount")
    private BigDecimal totalAmount;
}
