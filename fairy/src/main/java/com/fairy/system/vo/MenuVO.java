package com.fairy.system.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author deyong_tong
 */
@Data
public class MenuVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 父菜单ID，一级菜单为0
     */
    private Integer parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer orderNum;

    private Integer status;
    private Date createTime;
    private Date updateTime;

    /**
     * 子节点
     */
    private List<MenuVO> children;

}
