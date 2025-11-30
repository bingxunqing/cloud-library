package page.bingx.study2bean.dao;

import org.apache.ibatis.annotations.Mapper;
import page.bingx.study2bean.pojo.Order;
import page.bingx.study2bean.pojo.OrderItem;
import page.bingx.study2bean.pojo.OrderSearch;

import java.util.List;

/**
 * @program: study2-bean
 * @description: 订单的接口
 * @author: bingxunqing
 * @create: 2025-11-23 16:55
 */
@Mapper
public interface OrderDao {
    int InsertOrder(Order order);

    int InsertOrderItem( List<OrderItem> orderItem);

    List<Order> searchOrder(OrderSearch orderSearch);
    List<Order> selectOrderByUserId(Integer userId);
}
