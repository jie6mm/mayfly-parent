package com.jie6mm.mayfly.biz.database.mapper.user;

import com.jie6mm.mayfly.pojo.database.user.UserInfoDO;

import java.util.List;

/**
 * UserInfoDOMapper
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
public interface UserInfoMapper {

    int insertSelective(UserInfoDO record);

    int updateBatchSelective(List<UserInfoDO> list);

    int insertOrUpdate(UserInfoDO record);

    int insertOrUpdateSelective(UserInfoDO record);

    List<UserInfoDO> selectByAll(UserInfoDO userInfoDO);
}