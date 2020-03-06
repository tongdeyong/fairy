package com.fairy.system.vo;

import lombok.Data;

/**
 * @author deyong_tong
 */
@Data
public class ColumnVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String tableName;

}
