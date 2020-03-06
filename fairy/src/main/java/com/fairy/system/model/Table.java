package com.fairy.system.model;

import lombok.Data;

import java.util.Date;


/**
 * @author deyong_tong
 */
@Data
public class Table {
    /**
     * 表的名称
     */
    private String tableName;
    /**
     * 引擎
     */
    private String engine;
    /**
     * 表的备注
     */
    private String tableComment;

    private Date createTime;

}
