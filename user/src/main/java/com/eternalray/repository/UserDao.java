package com.eternalray.repository;

import com.eternalray.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Eternalray
 */
public interface UserDao extends JpaRepository<User,String> {
}
