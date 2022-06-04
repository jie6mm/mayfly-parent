package com.jie6mm.mayfly.tool.log;


import org.slf4j.Logger;

/**
 * 启动中
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/3
 */
public class ApplicationStartingUpLog {

    public static void configPropertyEndPrint(Logger logger) {
        logger.info("{}, 属性配置成功", logger.getName());
    }
}
