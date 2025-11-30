package page.bingx.study2bean.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @program: study2-bean
 * @description: MyBatis测试用的工具类
 * @author: bingxunqing
 * @create: 2025-11-23 15:05
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try{
            String resource = "mybatis-config.xml";
            java.io.InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
