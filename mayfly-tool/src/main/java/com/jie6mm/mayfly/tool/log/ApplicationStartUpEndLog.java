package com.jie6mm.mayfly.tool.log;

import lombok.Data;
import org.slf4j.Logger;

/**
 * 启动结束
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/3
 */
@Data
public class ApplicationStartUpEndLog {

    public static void startUpEndPrint(Logger logger) {
        logger.info("{}, 启动成功", logger.getName());
    }
}
