package com.jie6mm.mayfly.core.mybatis;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 不加载Mybatis
 *
 * @author jie6mm(刘杰)
 * @date 2022/5/28
 */
@ConditionalOnProperty(name = "mayfly.mysql.enable", havingValue = "false")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class MybatisDisableConfig {
}
