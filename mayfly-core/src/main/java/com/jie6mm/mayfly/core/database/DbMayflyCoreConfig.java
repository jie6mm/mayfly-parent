package com.jie6mm.mayfly.core.database;

import com.jie6mm.mayfly.core.database.druid.MayflyDruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


/**
 * mayfly_core数据库连接
 *
 * @author jie6mm(刘杰)
 * @date 2022/5/28
 */
@Configuration
@ConditionalOnProperty(name = {
        "mayfly.database.enable",
        "mayfly.database.core.enable"
}, havingValue = "true")
@MapperScan(basePackages = "com.jie6mm.mayfly.biz.system.database.mapper.core", sqlSessionFactoryRef = "mayflyCoreSqlSessionFactory")
public class DbMayflyCoreConfig {

    @Value("${mayfly.database.address:}")
    private String address;

    @Value("${mayfly.database.username:}")
    private String username;

    @Value("${mayfly.database.password:}")
    private String password;

    /**
     * 数据源
     *
     * @return
     */
    @Primary
    @Bean("mayflyCoreDataSource")
    @ConditionalOnProperty(name = "mayfly.database.core.enable", havingValue = "true")
    public DataSource mayflyCoreDataSource() {
        return MayflyDruidDataSource.getDruidDataSource(this.address, this.username, this.password, "mayfly_core");
    }

    /**
     * <p>事务管理器</p>
     * 使用@Primary进行修饰以后，当@Transational注解修饰的方法中设计到两个数据原时，发生事务回滚只会回滚被@Primary修饰的sql。
     *
     * @return
     */
    @Primary
    @Bean(name = "mayflyCoreTransactionManager")
    @ConditionalOnProperty(name = "mayfly.database.core.enable", havingValue = "true")
    public DataSourceTransactionManager mayflyCoreTransactionManager() {
        return new DataSourceTransactionManager(mayflyCoreDataSource());
    }

    /**
     * 编程式事务模板
     *
     * @return
     */
    @Bean(name = "mayflyCoreTransactionTemplate")
    @ConditionalOnProperty(name = "mayfly.database.core.enable", havingValue = "true")
    public TransactionTemplate mayflyCoreTransactionTemplate() {
        return new TransactionTemplate(mayflyCoreTransactionManager());
    }

    /**
     * SqlSession工厂
     *
     * @param mayflyCoreDataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = "mayflyCoreSqlSessionFactory")
    @ConditionalOnProperty(name = "mayfly.database.core.enable", havingValue = "true")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("mayflyCoreDataSource") DataSource mayflyCoreDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mayflyCoreDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/core/*Mapper.xml"));
        return sessionFactory.getObject();
    }
}