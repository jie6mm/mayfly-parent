package com.jie6mm.mayfly.biz.database.mapper.core;

import com.jie6mm.mayfly.pojo.database.core.SystemDictDO;

import java.util.List;

/**
 * SystemDictMapper
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
public interface SystemDictMapper {

    int insertSelective(SystemDictDO record);

    int updateBatchSelective(List<SystemDictDO> list);

    int insertOrUpdate(SystemDictDO record);

    int insertOrUpdateSelective(SystemDictDO record);

    List<SystemDictDO> selectByAll(SystemDictDO systemDictDO);
}