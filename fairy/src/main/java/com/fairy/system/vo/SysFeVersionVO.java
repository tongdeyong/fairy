package com.fairy.system.vo;

import lombok.Data;

/**
 * @author deyong_tong
 */
@Data
public class SysFeVersionVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

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

}
