package com.chenshun.pay.common.utils.export;

import java.util.List;

/**
 * User: mew <p />
 * Time: 18/4/12 13:48  <p />
 * Version: V1.0  <p />
 * Description: 数据导出,数据源 <p />
 */
public interface ExportDataSource<T> {

    <T> List<T> getData();

}
