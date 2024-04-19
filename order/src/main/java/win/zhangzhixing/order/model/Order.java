package win.zhangzhixing.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "t_order")
public class Order {
    @TableId(value = "id")
    private String id;
    @TableField(value = "user_id")
    private String userId;
    @TableField(value = "product_id")
    private String productId;
    @TableField(value = "status")
    private String status;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "total_amount")
    private BigDecimal totalAmount;
    @TableField(value = "qty")
    private Integer qty;
}
