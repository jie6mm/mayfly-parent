package com.jie6mm.mayfly.core.database;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 不连接数据库及排除相关依赖
 *
 * @author jie6mm(刘杰)
 * @date 2022/5/28
 */
@Configuration
@ConditionalOnProperty(name = "mayfly.database.enable", havingValue = "false")
@EnableAutoConfiguration(exclude = {
        // spring-boot
        DataSourceAutoConfiguration.class,
        // alibaba-druid
        DruidDataSourceAutoConfigure.class,
        // mybatis
        MybatisAutoConfiguration.class
})
public class DbDisableConfig {

}