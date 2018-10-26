package com.eternalray.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: Eternalray
 */
@Entity
@Table(name = "sys_user")
@Data
public class User {
    @Id
    private String id;
    @Column(name = "custom_id")
    private Integer customId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "head_portrait")
    private String headPortrait;
    @Column(name = "phone")
    private String phone;
    @Column(name = "creat_date")
    private Date creatDate;
    @Column(name = "is_del")
    private Integer isDel;
}
