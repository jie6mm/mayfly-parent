package com.jie6mm.mayfly.pojo.database.user;

import com.jie6mm.mayfly.pojo.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户基础信息
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/4
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDO extends BaseDO {

    /**
    * 用户id
    */
    private String userId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 用户年龄
    */
    private Integer userAge;

    /**
    * 用户邮箱
    */
    private String userEmail;

    /**
    * 用户注册时间
    */
    private Date userRegisterTime;

    /**
    * 用户状态
    */
    private String userStatus;

    /**
    * 用户登陆方式
    */
    private String userLoginType;
}