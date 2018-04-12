package com.chenshun.account.provider.dao;

import com.chenshun.account.api.entity.AccountHistory;
import com.chenshun.account.api.vo.DailyCollectAccountHistoryVo;
import com.chenshun.pay.common.core.dao.BaseDao;

import java.util.List;

/**
 * User: mew <p />
 * Time: 18/4/12 17:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface AccountHistoryDao extends BaseDao<AccountHistory> {

    /**
     * 获取账户历史
     *
     * @param accountNo
     * @param requestNo
     * @param trxType
     * @return
     */
    AccountHistory getByAccountNo_requestNo_trxType(String accountNo, String requestNo, Integer trxType);

    /**
     * 日汇总账户待结算金额
     *
     * @param accountNo
     * @param statDate
     * @param riskDay
     * @param fundDirection
     * @return
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskDay, Integer fundDirection);

    /**
     * 日汇总账户待结算金额_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo);

    /**
     * 更新账户风险预存期外的账户历史记录记为结算完成
     *
     * @param accountNo
     * @param statDate
     * @param riskDay
     */
    void updateCompleteSettTo100(String accountNo, String statDate, Integer riskDay);

    /**
     * 更新账户历史记录记为结算完成_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     */
    void updateCompleteSettTo100_t0(String accountNo, String requestNo);

    /**
     * 更新账户历史记录记为结算完成
     *
     * @param accountNo
     * @param lastId
     */
    void updateCompleteSettTo100LastId(String accountNo, Long lastId);

}
