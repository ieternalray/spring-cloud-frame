package com.eternalray;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.eternalray.controller.UserAuthController;
import com.eternalray.utils.jwt.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    UserAuthController userAuthController;

    @Test
    public void contextLoads() {
    }

    @Test
    public void jwtUtils() throws InterruptedException {
        Map<String,Object> map=new HashMap<>();
        map.put("userName","Eternalray");
        map.put("userId",1);
        //生成JWT Token
        String token = JwtUtil.getToken(10L, map);
        //验证JWT Token
        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
        //获取并解析JWT Token 附带参数值
        String payload = decodedJWT.getPayload();
        System.out.println(payload);
    }
    @Test
    public void login(){
        System.out.println(userAuthController.login("Eternalray","123456"));
    }
}
