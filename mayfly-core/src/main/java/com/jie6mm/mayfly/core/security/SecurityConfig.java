package com.jie6mm.mayfly.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * SecurityConfig
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/3
 */
@Configuration
public class SecurityConfig extends WebMvcConfigurationSupport {

    @Bean
    @SuppressWarnings("all")
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 认证授权
                .authorizeRequests()
                // 任何人都可以访问
                .antMatchers("/druid/**").permitAll()
                // 需要经过认证
                .anyRequest().authenticated()
                // csrf(Cross-site request forgery)跨站请求伪造 攻击
                .and()
                .csrf().disable().cors()
                // 可使用表单登陆
                .and()
                .formLogin()
                // 构建SecurityFilterChain对象
                .and().build();
    }
}
