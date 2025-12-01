package page.bingx.study2bean.dao;

import org.apache.ibatis.annotations.Param;
import page.bingx.study2bean.pojo.User;

/**
 * @program: study-ssm
 * @description: 操作用户数据库层
 * @author: bingxunqing
 * @create: 2025-12-01 23:31
 */
public interface UserDao {
    // java在编译的时候会改变参数名，这样mybatis的反射机制就难以正确找到对应的参数，
    // 因从多参数的时候最好使用@Param 注解，本质是生成一个map集合，key是@Param的值，value是参数值
    User Login(@Param("UserName") String userName, @Param("UserPassword") String userPassword);
}
