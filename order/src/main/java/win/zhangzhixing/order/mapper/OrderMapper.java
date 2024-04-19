package win.zhangzhixing.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import win.zhangzhixing.order.model.Order;
import win.zhangzhixing.order.response.OrderResp;

import java.math.BigDecimal;
import java.util.Date;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    Page<OrderResp> query(
            @Param("userId") String userId,
            @Param("productId") String productId,
            @Param("status") String status,
            @Param("startCreateTime") Date startCreateTime,
            @Param("endCreateTime") Date endCreateTime,
            @Param("page") Page<OrderResp> page
    );
}
