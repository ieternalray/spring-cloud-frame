package com.eternalray.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.eternalray.common.Result;
import com.eternalray.entity.UserAuth;
import com.eternalray.repository.UserAuthDao;
import com.eternalray.utils.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: Eternalray
 */
@Service
public class UserAuthService{
    @Autowired
    UserAuthDao userAuthDao;

    /**
     * 用户登陆
     * @param userName
     * @param password
     * @return
     */
    public Object login(String userName,String password){
        UserAuth loginResult = userAuthDao.login(userName, password);
        if(loginResult != null){
            //业务逻辑处理 登陆成功后需要返回的信息
            HashMap<String, Object> resultData = new HashMap<>(16);
            resultData.put("uId",loginResult.getId());
            resultData.put("uName",loginResult.getUserName());
            //token有效期为20分钟
            Long expires=20*60L;
            return Result.set(true,JwtUtil.getToken(expires,resultData));
        }else{
            return Result.set(false,"用户名或密码错误！");
        }
    }

    /**
     * 验证token是否合法
     * @param token
     * @return
     */
    public Object verifyToken(String token){
        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
        if (decodedJWT != null){
            return Result.set(true,decodedJWT);
        }else{
            return Result.set(false,null);
        }
    }
}
