package com.eternalray.service;

import com.eternalray.common.Result;
import com.eternalray.entity.User;
import com.eternalray.entity.vo.UserVo;
import com.eternalray.repository.UserDao;
import com.eternalray.utils.CustomUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: Eternalray
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Object regiest(UserVo userVo,boolean isPhoneRegiest){
        User user=new User();
        String userName=userVo.getUserName();
        String password=userVo.getPassword();
        String phone=userVo.getPhone();
        if(isPhoneRegiest){
            userName=phone;
        }
        if (StringUtils.isEmpty(userVo.getId())){
            String id=CustomUtils.getUUID();
            user.setId(id);
            user.setNickName("u"+userName);
        }
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setCreatDate(new Date());
        user.setIsDel(0);
        userDao.save(user);
        return Result.set(true,"保存成功！");
    }
}
