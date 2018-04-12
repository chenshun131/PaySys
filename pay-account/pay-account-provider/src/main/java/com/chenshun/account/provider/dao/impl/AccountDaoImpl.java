package com.chenshun.account.provider.dao.impl;

import com.chenshun.account.api.entity.Account;
import com.chenshun.account.provider.dao.AccountDao;
import com.chenshun.pay.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 17:58  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

    /**
     * 生成账户编号20位
     */
    @Override
    public String buildAccountNo(String accountType) {
        // 获取账户编号序列值，用于生成20位的账户编号
        String accountNoSeq = super.getSeqNextValue("ACCOUNT_NO_SEQ");
        // 构造账户编号
        return "8008" + accountType + accountNoSeq + "0101";
    }

    /**
     * 根據帳戶編號獲取帳戶信息
     *
     * @param accountNo
     * @return
     */
    @Override
    public Account getByAccountNo(String accountNo) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("accountNo", accountNo);
        return super.getBy(params);
    }

    /**
     * 获取账户实体
     *
     * @param userNo
     * @param isPessimist
     *         是否乐观锁
     * @return
     */
    @Override
    public Account getByUserNo_IsPessimist(String userNo, boolean isPessimist) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("userNo", userNo);
        params.put("isPessimist", isPessimist);
        return super.getBy(params);
    }

}
