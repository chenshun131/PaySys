package com.chenshun.pay.common.utils.export.excel;

import com.chenshun.pay.common.utils.export.DataField;

/**
 * User: mew <p />
 * Time: 18/4/12 13:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class ExcelDataField extends DataField {

    private int width;

    private CellRender render;

    private CellRender headRender;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public CellRender getRender() {
        return render;
    }

    public void setRender(CellRender render) {
        this.render = render;
    }

    public CellRender getHeadRender() {
        return headRender;
    }

    public void setHeadRender(CellRender headRender) {
        this.headRender = headRender;
    }

}
