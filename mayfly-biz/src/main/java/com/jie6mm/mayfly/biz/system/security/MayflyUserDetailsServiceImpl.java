package com.jie6mm.mayfly.biz.system.security;

import com.google.common.collect.Lists;
import com.jie6mm.mayfly.biz.system.database.repository.user.UserInfoRepository;
import com.jie6mm.mayfly.pojo.database.user.UserInfoDO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * {title}
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MayflyUserDetailsServiceImpl implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoDO userInfoDTO = userInfoRepository.queryUserInfoByUsername(username);
        if (ObjectUtils.isEmpty(userInfoDTO)) {
            throw new NullPointerException(username + "不存在");
        }
        return new User(username, "admin", Lists.newArrayList(new SimpleGrantedAuthority("ROLE_SUPPER-ADMIN")));
    }

}
