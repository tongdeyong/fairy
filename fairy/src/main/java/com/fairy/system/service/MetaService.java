package com.fairy.system.service;

import com.fairy.system.model.Column;
import com.fairy.system.model.Table;
import com.fairy.system.vo.ColumnVO;
import com.fairy.system.vo.TableVO;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author deyong_tong
 */
public interface MetaService {

    /**
     * 查询库表
     * @param tableVO tableVO
     * @return list
     */
    List<Table> listTable(TableVO tableVO);

    /**
     * 查询库字段
     * @param columnVO columnVO
     * @return list
     */
    List<Column> listColumn(ColumnVO columnVO);

    /**
     * 查询sql
     * @param sql sql
     * @return list
     */
    List<Map<String, Object>> querySql(String sql);

    /**
     *生成sql
     * @param tableVO tableVO
     * @return ByteArrayOutputStream
     */
    ByteArrayOutputStream generateSql(TableVO tableVO);
}
