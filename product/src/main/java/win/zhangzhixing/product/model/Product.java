package win.zhangzhixing.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "t_product")
public class Product {
    @TableId(value = "id")
    private String id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "description")
    private String description;
    @TableField(value = "price")
    private BigDecimal price;
    @TableField(value = "qty")
    private Integer qty;
    @TableField(value = "create_time")
    private Date createTime;
}