package com.chenshun.pay.common.utils.export;

/**
 * User: mew <p />
 * Time: 18/4/12 13:48  <p />
 * Version: V1.0  <p />
 * Description: 数据 Field <p />
 */
public class DataField {

    /** 字段名称 */
    private String name;

    /** 字段名 */
    private String field;

    /** 列宽 */
    private int columnWidth = 15;

    public DataField() {
    }

    public DataField(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public DataField(String name, String field, int columnWidth) {
        this.name = name;
        this.field = field;
        this.columnWidth = columnWidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

}
