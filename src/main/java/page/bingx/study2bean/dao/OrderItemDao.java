package page.bingx.study2bean.dao;

import page.bingx.study2bean.pojo.OrderItem;

/**
 * @program: study2-bean
 * @description: 商品与订单对应的表的数据库操作
 * @author: bingxunqing
 * @create: 2025-11-29 15:27
 */
public interface OrderItemDao {

    OrderItem findOrderItemById(Integer id);
}
