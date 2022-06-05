package com.jie6mm.mayfly.biz.system.database.repository.core;


import com.jie6mm.mayfly.biz.system.database.mapper.core.SystemDictMapper;
import com.jie6mm.mayfly.pojo.database.core.SystemDictDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * SystemDictRepository
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Component
public class SystemDictRepository {

    @Autowired(required = false)
    private SystemDictMapper mapper;

    /**
     * 按所有条件查询(等于)
     * @param systemDictDO
     * @return
     */
    public List<SystemDictDO> queryByAllCondition(SystemDictDO systemDictDO) {
       return Optional.ofNullable(systemDictDO)
                .map(condition -> mapper.selectByAll(condition))
                .orElse(Collections.emptyList());
    }
}