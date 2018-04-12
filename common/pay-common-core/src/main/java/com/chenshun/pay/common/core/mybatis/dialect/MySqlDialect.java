package com.chenshun.pay.common.core.mybatis.dialect;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 11:5  <p />
 * Version: V1.0  <p />
 * Description: MySQL数据库分页适配器 <p />
 */
public class MySqlDialect extends Dialect {

    @Override
    public boolean supportsLimitOffset() {
        return true;
    }

    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        if (offset > 0) {
            sql += " limit " + offsetPlaceholder + "," + limitPlaceholder;
        } else {
            sql += " limit " + limitPlaceholder;
        }
        return sql;
    }

}
