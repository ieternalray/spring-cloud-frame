package com.eternalray.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Eternalray
 */
@Entity
@Table(name = "sys_user")
@Data
public class UserAuth {
    @Id
    private String id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
