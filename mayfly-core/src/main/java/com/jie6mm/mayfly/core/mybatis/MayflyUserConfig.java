package com.jie6mm.mayfly.core.mybatis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 配置[mayfly_user]数据库连接
 *
 * @author jie6mm(刘杰)
 * @date 2022/5/28
 */
@ConditionalOnProperty(name = "mayfly.mysql.user.enable", havingValue = "true")
public class MayflyUserConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://jie6mm.com:13306/mayfly_user");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }
}