package com.fairy.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author deyong_tong
 */
@Data
public class RoleVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String roleName;

    private Integer roleId;

    private List<Integer> menuIdList;

}
