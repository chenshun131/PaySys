package com.chenshun.account.api.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/4/12 17:06  <p />
 * Version: V1.0  <p />
 * Description: 结算日汇总vo <p />
 */
public class DailyCollectAccountHistoryVo implements Serializable {

    private static final long serialVersionUID = -2451289258390618916L;

    /** 账户编号 */
    private String accountNo;

    /** 汇总日期 */
    private Date collectDate;

    /** 总金额 */
    private Double totalAmount = 0D;

    /** 总笔数 */
    private Integer totalNum = 0;

    /** 最后ID */
    private Long lastId = 0L;

    /** 风险预存期 */
    private Integer riskDay;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    public Integer getRiskDay() {
        return riskDay;
    }

    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }

}
