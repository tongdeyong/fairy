package com.fairy.system.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author deyong_tong
 */
@Data
public class UserVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private Integer deptId;

    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户真实姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出身日期
     */
    private Date birth;
    /**
     * 图片ID
     */
    private String image;
    /**
     * 状态 0:禁用，1:正常
     */
    private Integer status;

}
