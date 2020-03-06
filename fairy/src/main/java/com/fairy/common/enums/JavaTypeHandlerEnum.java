package com.fairy.common.enums;

/**
 * @author deyong_tong
 */

public enum JavaTypeHandlerEnum {

    CHAR("CHAR", "String"),
    VARCHAR("VARCHAR", "String"),
    LONGVARCHAR("LONGVARCHAR", "String"),
    MEDIUMTEXT("MEDIUMTEXT", "String"),
    NUMERIC("NUMERIC", "BigDecimal"),
    DECIMAL("DECIMAL", "BigDecimal"),
    BIT("BIT", "Boolean"),
    BOOLEAN("DECIMAL", "Boolean"),
    TINYINT("TINYINT", "Integer"),
    SMALLINT("SMALLINT", "Short"),
    INTEGER("INTEGER", "Integer"),
    INT("INT", "Integer"),
    BIGINT("BIGINT", "Long"),
    REAL("REAL", "Float"),
    FLOAT("FLOAT", "Float"),
    DOUBLE("DOUBLE", "Double"),
    DATE("DATE", "Date"),
    DATETIME("DATETIME", "Date"),
    TIME("TIME", "Time"),
    TIMESTAMP("TIMESTAMP", "Date");

    private String jdbcType;

    private String javaType;

    JavaTypeHandlerEnum(String jdbcType, String javaType) {
        this.javaType = javaType;
        this.jdbcType = jdbcType;
    }

    public static JavaTypeHandlerEnum getByJdbcType(String jdbcType) {
        JavaTypeHandlerEnum[] values = JavaTypeHandlerEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].jdbcType.equals(jdbcType)) {
                return values[i];
            }
        }
        return null;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }
}
