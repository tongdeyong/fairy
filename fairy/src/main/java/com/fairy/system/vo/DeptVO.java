package com.fairy.system.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author deyong_tong
 */
@Data
public class DeptVO {

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
    private String deptName;

    /**
     * 可用状态 1.可用 2.不可用
     */
    private Integer status;

    private Integer orderNum;

    private Date createTime;

    private Date updateTime;

    /**
     * 子节点
     */
    private List<DeptVO> children;
}
