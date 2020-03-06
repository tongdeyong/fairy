package com.fairy.system.model;

import lombok.Data;

import java.util.Date;

/**
 * @author deyong_tong
 */
@Data
public class SysFeVersion {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 版本
     */
    private String feVersion;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
