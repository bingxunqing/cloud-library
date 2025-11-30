package page.bingx.study2bean.dao;

import org.apache.ibatis.annotations.Mapper;
import page.bingx.study2bean.pojo.User;

/**
 * @author bingxunqin
 */
@Mapper
public interface UserDao {
    int save(User user);

    User findByName(String username);

    int deleteByName(String username);

    int update(User user);

    User findUserWithOrders(Integer id);

    User findUserWithOrdersAndProduct(Integer id);
    User findUserLazy(Integer id);
}
