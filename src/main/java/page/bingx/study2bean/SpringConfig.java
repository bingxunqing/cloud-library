package page.bingx.study2bean;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @program: study2-bean
 * @description: spring配置文件（数据库连接）
 * @author: bingxunqing
 * @create: 2025-11-29 16:47
 */

// 声明是配置类
@Configuration
// 声明扫描的组件的地方
@ComponentScan("page.bingx.study2bean")
// 声明扫描的mapper接口的包
@MapperScan("page.bingx.study2bean.dao")
// 加载数据库连接的相关配置
@PropertySource("classpath:db.properties")
public class SpringConfig {
    // 从 db.properties 读取值
    @Value("${mysql.driver}") private String driver;
    @Value("${mysql.url}") private String url;
    @Value("${mysql.username}") private String username;
    @Value("${mysql.password}") private String password;

    // 1. 配置数据源 (Spring 接管连接池)
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 2. 配置 SqlSessionFactory (整合的核心)
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        // 关键：引入你原来的 mybatis-config.xml (保留设置和别名)
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));

        // 关键：告诉 Spring mapper.xml 文件在哪里 (虽然你在 config 里配了，但这里双重保险)
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));

        return factoryBean;
    }

    // 3. 配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
