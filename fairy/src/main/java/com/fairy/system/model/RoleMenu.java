package com.fairy.system.model;

import lombok.Data;

import java.util.Date;

/**
 * @author deyong_tong
 */
@Data
public class RoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;
    private Date createTime;
    private Date updateTime;
}
