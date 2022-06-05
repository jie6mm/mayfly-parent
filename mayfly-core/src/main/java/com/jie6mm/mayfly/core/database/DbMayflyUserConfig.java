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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


/**
 * mayfly_user数据库连接
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Configuration
@ConditionalOnProperty(name = {
        "mayfly.database.enable",
        "mayfly.database.user.enable"
}, havingValue = "true")
@MapperScan(basePackages = "com.jie6mm.mayfly.biz.system.database.mapper.user", sqlSessionFactoryRef = "mayflyUserSqlSessionFactory")
public class DbMayflyUserConfig {

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
    @Bean("mayflyUserDataSource")
    @ConditionalOnProperty(name = "mayfly.database.user.enable", havingValue = "true")
    public DataSource mayflyUserDataSource() {
        return MayflyDruidDataSource.getDruidDataSource(this.address, this.username, this.password, "mayfly_user");
    }

    /**
     * 事务管理器
     *
     * @return
     */
    @Bean(name = "mayflyUserTransactionManager")
    @ConditionalOnProperty(name = "mayfly.database.user.enable", havingValue = "true")
    public DataSourceTransactionManager mayflyUserTransactionManager() {
        return new DataSourceTransactionManager(mayflyUserDataSource());
    }

    /**
     * 编程式事务模板
     *
     * @return
     */
    @Bean(name = "mayflyUserTransactionTemplate")
    @ConditionalOnProperty(name = "mayfly.database.user.enable", havingValue = "true")
    public TransactionTemplate mayflyUserTransactionTemplate() {
        return new TransactionTemplate(mayflyUserTransactionManager());
    }

    /**
     * SqlSession工厂
     *
     * @param mayflyUserDataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "mayflyUserSqlSessionFactory")
    @ConditionalOnProperty(name = "mayfly.database.user.enable", havingValue = "true")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("mayflyUserDataSource") DataSource mayflyUserDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mayflyUserDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/user/*Mapper.xml"));
        return sessionFactory.getObject();
    }
}