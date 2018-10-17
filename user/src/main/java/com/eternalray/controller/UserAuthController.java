package com.eternalray.controller;

import com.eternalray.service.UserAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Eternalray
 */
@Api(tags = "用户认证")
@RestController
public class UserAuthController {
    @Autowired
    UserAuthService userAuthService;

    @ApiOperation(value = "用户登陆")
    @PostMapping("/login")
    public Object login(String userName,String password){
        return userAuthService.login(userName, password);
    }
    @ApiOperation(value = "验证token是否合法")
    @PostMapping("/verifyToken")
    public Object verifyToken(String token){
        return userAuthService.verifyToken(token);
    }
}
