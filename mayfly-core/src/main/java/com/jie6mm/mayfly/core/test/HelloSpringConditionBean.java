package com.jie6mm.mayfly.core.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 测试SpringCondition
 *
 * @author jie6mm(刘杰)
 * @date 2022/5/26
 */
@Slf4j
public class HelloSpringConditionBean {

    @Value("${server.port:}")
    private String serverPort;

    @Bean
    public void ad() {
        log.info("HelloSpringConditionBean被激活serverPort[{}]", serverPort);
    }
}
