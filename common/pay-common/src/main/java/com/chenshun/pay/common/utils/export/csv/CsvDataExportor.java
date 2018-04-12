package com.chenshun.pay.common.utils.export.csv;

import com.chenshun.pay.common.utils.export.DataField;
import com.chenshun.pay.common.utils.export.ExportDataSource;
import com.chenshun.pay.common.utils.export.txt.TxtDataExportor;

import java.io.OutputStream;

/**
 * User: mew <p />
 * Time: 18/4/12 13:44  <p />
 * Version: V1.0  <p />
 * Description: csv格式数据导出工具 <p />
 */
public class CsvDataExportor<T> extends TxtDataExportor<T> {

    public CsvDataExportor(DataField[] fields, ExportDataSource<T> dataSource, OutputStream os) {
        super(fields, dataSource, os, ",");
    }

}
