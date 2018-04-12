package com.chenshun.pay.common.page;

import java.io.Serializable;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:36  <p />
 * Version: V1.0  <p />
 * Description: 分页参数传递工具类 <p />
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = 5803258804806187801L;

    /** 当前页数 */
    private int pageNum;

    /** 每页记录数 */
    private int numPerPage;

    public PageParam(int pageNum, int numPerPage) {
        super();
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

}
