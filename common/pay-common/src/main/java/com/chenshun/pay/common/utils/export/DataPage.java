package com.chenshun.pay.common.utils.export;

/**
 * User: mew <p />
 * Time: 18/4/12 13:48  <p />
 * Version: V1.0  <p />
 * Description: 分页参数 <p />
 */
public class DataPage {

    /** 总页数 */
    private int countPage = 1;

    /** 一页中最多条目数 */
    private int maxEntityInOnePage;

    public DataPage() {
    }

    public DataPage(int maxEntityInOnePage) {
        this.maxEntityInOnePage = maxEntityInOnePage;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getMaxEntityInOnePage() {
        return maxEntityInOnePage;
    }

    public void setMaxEntityInOnePage(int maxEntityInOnePage) {
        this.maxEntityInOnePage = maxEntityInOnePage;
    }

}
