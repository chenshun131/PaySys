package com.chenshun.account.provider.dao.impl;

import com.chenshun.account.api.entity.AccountHistory;
import com.chenshun.account.api.vo.DailyCollectAccountHistoryVo;
import com.chenshun.account.provider.dao.AccountHistoryDao;
import com.chenshun.pay.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 18:00  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Repository("accountHistoryDao")
public class AccountHistoryDaoImpl extends BaseDaoImpl<AccountHistory> implements AccountHistoryDao {

    /**
     * 获取账户历史
     *
     * @param accountNo
     * @param requestNo
     * @param trxType
     * @return
     */
    @Override
    public AccountHistory getByAccountNo_requestNo_trxType(String accountNo, String requestNo, Integer trxType) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("accountNo", accountNo);
        params.put("requestNo", requestNo);
        params.put("trxType", trxType);
        return super.getBy(params);
    }

    /**
     * 日汇总账户待结算金额
     *
     * @param accountNo
     * @param statDate
     * @param riskDay
     * @param fundDirection
     * @return
     */
    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskDay,
                                                                               Integer fundDirection) {
        Map<String, Object> params = new HashMap<>(4);
        params.put("accountNo", accountNo);
        params.put("statDate", statDate);
        params.put("riskDay", riskDay);
        params.put("fundDirection", fundDirection);
        return super.getSessionTemplate().selectList(getStatement("listDailyCollectAccountHistoryVo"), params);
    }

    /**
     * 日汇总账户待结算金额_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     */
    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("accountNo", accountNo);
        params.put("requestNo", requestNo);
        return super.getSessionTemplate().selectList(getStatement("listDailyCollectAccountHistoryVo_t0"), params);
    }

    /**
     * 更新账户风险预存期外的账户历史记录记为结算完成
     *
     * @param accountNo
     * @param statDate
     * @param riskDay
     */
    @Override
    public void updateCompleteSettTo100(String accountNo, String statDate, Integer riskDay) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("accountNo", accountNo);
        params.put("statDate", statDate);
        params.put("riskDay", riskDay);
        super.getSessionTemplate().update(getStatement("updateCompleteSettTo100"), params);
    }

    /**
     * 更新账户历史记录记为结算完成_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     */
    @Override
    public void updateCompleteSettTo100_t0(String accountNo, String requestNo) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("accountNo", accountNo);
        params.put("requestNo", requestNo);
        super.getSessionTemplate().update(getStatement("updateCompleteSettTo100_t0"), params);
    }

    /**
     * 更新账户历史记录记为结算完成
     *
     * @param accountNo
     * @param lastId
     */
    @Override
    public void updateCompleteSettTo100LastId(String accountNo, Long lastId) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("accountNo", accountNo);
        params.put("lastId", lastId);
        super.getSessionTemplate().update(getStatement("updateCompleteSettTo100LastId"), params);
    }

}
