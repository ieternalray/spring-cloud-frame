package com.eternalray.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Eternalray
 * 用户服务
 */
@FeignClient("user")
public interface UserAuthClient {

    /**
     * 用户登陆
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    Object login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password);

    /**
     * 鉴权
     * @param token
     * @return
     */
    @PostMapping("/verifyToken")
    Object verifyToken(@RequestParam(value = "token") String token);

}
