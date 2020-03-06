package com.fairy.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author deyong_tong
 */
@Data
public class TableVO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String tableName;

    private List<String> tableNameList;

    private String packageName = "com.fairy";

    private String module = "system";

    private Boolean removeTablePrefix = false;


}
