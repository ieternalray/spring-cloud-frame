package com.eternalray.controller;

import com.eternalray.entity.vo.UserVo;
import com.eternalray.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Eternalray
 */
@Api(tags = "用户管理")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "普通账户注册")
    @PostMapping("/register")
    public Object register(UserVo userVo){
        return userService.regiest(userVo,false);
    }
    @ApiOperation(value = "手机账户注册")
    @PostMapping("/usePhoneRegister")
    public Object usePhoneRegister(UserVo userVo){
        // TODO: 业务逻辑 手机号验证码验证
        return userService.regiest(userVo,true);
    }
}
