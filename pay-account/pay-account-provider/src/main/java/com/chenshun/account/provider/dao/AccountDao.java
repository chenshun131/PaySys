package com.chenshun.account.provider.dao;

import com.chenshun.account.api.entity.Account;
import com.chenshun.pay.common.core.dao.BaseDao;

/**
 * User: mew <p />
 * Time: 18/4/12 15:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface AccountDao extends BaseDao<Account> {

    /**
     * 生成账户编号20位
     *
     * @param accountType
     * @return
     */
    String buildAccountNo(String accountType);

    /**
     * 根据账户编号获取账户信息
     *
     * @param accountNo
     * @return
     */
    Account getByAccountNo(String accountNo);

    /**
     * 获取账户实体
     *
     * @param userNo
     * @param isPessimist
     *         是否乐观锁
     * @return
     */
    Account getByUserNo_IsPessimist(String userNo, boolean isPessimist);

}
