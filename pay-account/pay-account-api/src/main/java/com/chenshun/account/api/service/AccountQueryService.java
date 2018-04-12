package com.chenshun.account.api.service;

import com.chenshun.account.api.entity.Account;
import com.chenshun.account.api.entity.AccountHistory;
import com.chenshun.account.api.exception.AccountBizException;
import com.chenshun.account.api.vo.DailyCollectAccountHistoryVo;
import com.chenshun.pay.common.page.PageBean;
import com.chenshun.pay.common.page.PageParam;

import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 17:04  <p />
 * Version: V1.0  <p />
 * Description: 账户查询 <p />
 */
public interface AccountQueryService {

    /**
     * 账户历史查询
     *
     * @param pageParam
     *         分页参数
     * @param paramMap
     *         查询参数
     * @return AccountHistoryList
     * @throws AccountBizException
     */
    PageBean queryAccountHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException;

    /**
     * 获取账户历史
     *
     * @param accountNo
     * @param requestNo
     * @param trxType
     * @return
     */
    AccountHistory getAccountHistoryByAccountNo_requestNo_trxType(String accountNo, String requestNo, Integer trxType);

    /**
     * 根据用户编号获取账户信息 .
     *
     * @param userNo
     *         用户编号.
     * @return account 查询到的账户信息.
     * @throws AccountBizException
     */
    Account getAccountByUserNo(String userNo) throws AccountBizException;

    /**
     * 根据账户编号查询账户信息
     *
     * @param accountNo
     *         账户编号
     * @return account 查询到的账户信息
     * @throws AccountBizException
     */
    Account getAccountByAccountNo(String accountNo) throws AccountBizException;

    /**
     * 日汇总账户待结算金额
     *
     * @param accountNo
     *         账户编号
     * @param statDate
     *         统计日期
     * @param riskDay
     *         风险预测期
     * @param fundDirection
     *         资金流向
     * @return
     * @throws AccountBizException
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskDay, Integer fundDirection)
            throws AccountBizException;

    /**
     * 日汇总账户待结算金额_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo) throws AccountBizException;

}
