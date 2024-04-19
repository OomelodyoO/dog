package win.zhangzhixing.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import win.zhangzhixing.product.model.Product;
import win.zhangzhixing.product.response.ProductResp;

import java.util.Date;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    Page<ProductResp> query(
            @Param("name") String name,
            @Param("description") String description,
            @Param("startCreateTime") Date startCreateTime,
            @Param("endCreateTime") Date endCreateTime,
            @Param("page") Page<ProductResp> page
    );
}
