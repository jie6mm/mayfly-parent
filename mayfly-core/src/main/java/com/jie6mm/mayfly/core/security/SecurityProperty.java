package com.jie6mm.mayfly.core.security;

import com.jie6mm.mayfly.tool.log.ApplicationStartingUpLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 安全配置
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/2
 */
@Slf4j
public class SecurityProperty implements SmartApplicationListener, Ordered {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        // ApplicationEnvironmentPreparedEvent 是加载配置文件，初始化日志系统的事件
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ConfigurableEnvironment environment = ((ApplicationEnvironmentPreparedEvent) event).getEnvironment();
            System.setProperty("spring.security.user.name", "mayfly");
            System.setProperty("spring.security.user.password", "mayfly");
            // 此时日志系统还未准备好，所以以下日志并不会打印
            ApplicationStartingUpLog.configPropertyEndPrint(log);
        }
    }

    @Override
    public int getOrder() {
        // 设置该监听器 在加载配置文件之后执行
        return ConfigDataEnvironmentPostProcessor.ORDER + 1;
    }
}
