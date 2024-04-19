package win.zhangzhixing.product.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import win.zhangzhixing.product.model.Product;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class ProductResp {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer qty;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Date createTime;

    public ProductResp(Product product) {
        setId(product.getId());
        setName(product.getName());
        setDescription(product.getDescription());
        setPrice(product.getPrice());
        setQty(product.getQty());
        setCreateTime(product.getCreateTime());
    }
}
