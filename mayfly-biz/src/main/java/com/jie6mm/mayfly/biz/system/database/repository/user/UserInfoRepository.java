package com.jie6mm.mayfly.biz.system.database.repository.user;

import com.jie6mm.mayfly.biz.system.database.mapper.user.UserInfoMapper;
import com.jie6mm.mayfly.pojo.database.user.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * UserInfoRepository
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Component
public class UserInfoRepository {

    @Autowired(required = false)
    private UserInfoMapper mapper;

    /**
     * 按所有条件查询(等于)
     * @param userInfoDO
     * @return
     */
    public List<UserInfoDO> queryByAllCondition(UserInfoDO userInfoDO) {
        return Optional.ofNullable(userInfoDO)
                .map(condition -> mapper.selectByAll(condition))
                .orElse(Collections.emptyList());
    }

    /**
     * 根据username获取UserinfoDTO对象
     * @param username
     * @return
     */
    public UserInfoDO queryUserInfoByUsername(String username) {
        return Optional.ofNullable(username)
                .map(condition -> mapper.selectOneByAll(
                        UserInfoDO.builder().username(condition).build()
                ))
                .orElse(null);
    }
}
