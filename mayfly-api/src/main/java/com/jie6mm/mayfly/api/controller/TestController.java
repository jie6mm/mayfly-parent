package com.jie6mm.mayfly.api.controller;

import com.jie6mm.mayfly.biz.system.database.repository.core.SystemDictRepository;
import com.jie6mm.mayfly.biz.system.database.repository.user.UserInfoRepository;
import com.jie6mm.mayfly.pojo.database.core.SystemDictDO;
import com.jie6mm.mayfly.pojo.database.user.UserInfoDO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SystemDict
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final SystemDictRepository systemDictRepository;

    private final UserInfoRepository userInfoRepository;

    @GetMapping("/system-dict/all")
    public List<SystemDictDO> systemDictAllQueryAll() {
        return systemDictRepository.queryByAllCondition(new SystemDictDO());
    }

    @GetMapping("/user-info/all")
    public List<UserInfoDO> userInfoAllQueryAll() {
        return userInfoRepository.queryByAllCondition(new UserInfoDO());
    }
}
