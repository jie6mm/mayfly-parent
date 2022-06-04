package com.jie6mm.mayfly.api;

import com.jie6mm.mayfly.tool.log.ApplicationStartUpEndLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MayflyApiApplication
 *
 * @author jie6mm(刘杰)
 * @date 2022/06/02
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {
        "com.jie6mm.mayfly.api",
        "com.jie6mm.mayfly.biz",
        "com.jie6mm.mayfly.core"
})
public class MayflyApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MayflyApiApplication.class, args);
        ApplicationStartUpEndLog.startUpEndPrint(log);
    }
}