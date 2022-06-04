package com.jie6mm.mayfly.pojo.database.core;

import com.jie6mm.mayfly.pojo.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统字典
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemDictDO extends BaseDO {

    /**
    * 父id
    */
    private Long pid;

    /**
    * name
    */
    private String name;

    /**
    * value
    */
    private String value;

    /**
     * 顺序
     */
    private Integer sequence;
}