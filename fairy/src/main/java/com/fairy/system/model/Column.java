package com.fairy.system.model;

import lombok.Data;

/**
 * 表单属性
 * @author deyong_tong
 */
@Data
public class Column {
	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 列名类型
	 */
	private String columnType;
	/**
	 * 列名备注
	 */
	private String columnComment;

	/**
	 * 主键标识
	 */
	private String columnKey;

}
