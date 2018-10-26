package com.eternalray.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Eternalray
 */
@Data
public class UserVo {
    private String id;
    private Integer customId;
    private String userName;
    private String password;
    private String nickName;
    private String headPortrait;
    private String phone;
    private Date creatDate;
    private Integer isDel;
}
