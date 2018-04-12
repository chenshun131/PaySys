package com.chenshun.account.api.service;

import com.chenshun.account.api.exception.AccountBizException;

/**
 * User: mew <p />
 * Time: 18/4/12 17:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface AccountSetService {

    /**
     * 结算创建_T+0
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     *         结算请求
     * @param trxNo
     *         账户历史交易请求
     */
    void settCreateT0(String userNo, Double settAmount, String requestNo, String trxNo) throws AccountBizException;

    /**
     * 结算成功
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     */
    void settSuccess(String userNo, Double settAmount, String requestNo) throws AccountBizException;

    /**
     * 结算汇总成功
     *
     * @param userNo
     * @param statDate
     * @param riskDay
     */
    void settCollectSuccess(String userNo, String statDate, Integer riskDay) throws AccountBizException;

    /**
     * 结算创建
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     * @param lastId
     */
    void settCreate(String userNo, Double settAmount, String requestNo, Long lastId) throws AccountBizException;

    /**
     * 结算失败
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     */
    void settFail(String userNo, Double settAmount, String requestNo) throws AccountBizException;

}
