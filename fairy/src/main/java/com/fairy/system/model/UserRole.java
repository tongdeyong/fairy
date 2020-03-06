package com.fairy.system.model;

import lombok.Data;

import java.util.Date;

/**
 * @author deyong_tong
 */
@Data
public class UserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Date createTime;
    private Date updateTime;
}
