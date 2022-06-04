package com.jie6mm.mayfly.pojo.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseDO
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Byte flag;
}
