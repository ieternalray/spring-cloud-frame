package com.eternalray.service;

import com.eternalray.common.Result;
import com.eternalray.entity.UserAuth;
import com.eternalray.repository.UserAuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return Result.set(true,"登陆成功！");
        }else{
            return Result.set(false,"用户名或密码错误！");
        }
    }
}
