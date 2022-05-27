package com.jie6mm.mayfly.core.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * 测试SpringBean配置
 *
 * @author jie6mm(刘杰)
 * @date 2022/5/26
 */
@Slf4j
public class HelloSpringBean {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    @ConditionalOnProperty(name = "server.port", havingValue = "50501")
    public String hello() {
        log.info("hello mayfly...{}", serverPort);
        return "hello";
    }
}
