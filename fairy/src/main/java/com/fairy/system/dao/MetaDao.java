package com.fairy.system.dao;

import com.fairy.system.model.Column;
import com.fairy.system.model.Table;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 生成代码dao
 * @author deyong_tong
 */
public interface MetaDao {
    /**
     * 返回数据库表列表
     * @return list
     */
    @Select("select table_name, engine, table_comment, create_time from information_schema.tables"
            + " where table_schema = (select database())")
    List<Table> listTable();


    /**
     * 返回表字段
     * @param tableName 表名
     * @return 字段列表
     */
    @Select("select column_name, data_type columnType, column_comment, column_key from information_schema.columns"
            + " where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position")
    List<Column> listColumn(String tableName);
}
