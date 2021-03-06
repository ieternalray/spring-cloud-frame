package com.eternalray.repository;

import com.eternalray.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: Eternalray
 */
public interface UserAuthDao extends JpaRepository<UserAuth,String> {
    /**
     * 登陆获取用户信息
     * @param userName
     * @param password
     * @return
     */
    @Query(value = "FROM UserAuth WHERE user_name=?1 AND password=?2")
    UserAuth login(String userName,String password);
}
