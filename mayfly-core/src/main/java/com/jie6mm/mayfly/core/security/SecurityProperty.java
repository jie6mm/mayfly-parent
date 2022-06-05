package com.jie6mm.mayfly.core.security;

import com.jie6mm.mayfly.tool.log.ApplicationStartingUpLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 安全配置
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/2
 */
@Slf4j
public class SecurityProperty implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationContextInitializedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.setProperty("spring.security.user.name", "mayfly");
        System.setProperty("spring.security.user.password", "mayfly");
        ApplicationStartingUpLog.configPropertyEndPrint(log);
    }
}
