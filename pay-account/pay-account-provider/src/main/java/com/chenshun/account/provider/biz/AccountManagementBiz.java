package com.chenshun.account.provider.biz;

import com.chenshun.account.api.entity.Account;
import com.chenshun.account.api.entity.AccountFrozenRecord;
import com.chenshun.account.api.enums.AccountInitiatorEnum;
import com.chenshun.account.api.enums.AccountOperationTypeEnum;
import com.chenshun.account.api.enums.AccountStatusEnum;
import com.chenshun.account.api.enums.AccountTypeEnum;
import com.chenshun.account.api.exception.AccountBizException;
import com.chenshun.account.provider.dao.AccountDao;
import com.chenshun.account.provider.dao.AccountFrozenRecordDao;
import com.chenshun.pay.common.utils.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/4/12 18:05  <p />
 * Version: V1.0  <p />
 * Description: 账户管理biz <p />
 */
@Component("accountManagementBiz")
@Transactional(rollbackFor = Exception.class)
public class AccountManagementBiz {

    private static final Logger logger = LoggerFactory.getLogger(AccountManagementBiz.class);

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountFrozenRecordDao accountFrozenRecordDao;

    /**
     * 重新绑定商户编号
     *
     * @param accountNo
     * @param userNo
     * @return
     */
    public long reBindUserNo(String accountNo, String userNo) {
        logger.info("==>changeUserNo, accountNo:" + accountNo + ", userNo:" + userNo);

        Account account = accountDao.getByAccountNo(accountNo);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.print();
        }
        account.setUserNo(userNo);
        account.setLastTime(new Date());

        return accountDao.update(account);
    }

    /**
     * 生成账户编号20位
     *
     * @param accountType
     *         用户类型
     * @return @
     */
    public String buildAccountNo(AccountTypeEnum accountType) {
        String accountNo = accountDao.buildAccountNo(StringUtil.leftPadWithBytes(String.valueOf(accountType.getValue()), 3, '0', "UTF-8"));
        logger.info("==>buildAccountNo:" + accountNo);
        return accountNo;
    }

    /**
     * 创建账户
     *
     * @param userNo
     * @param accountNo
     * @param accountType
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public long createAccount(String userNo, String accountNo, int accountType) {
        logger.info("==>createAccount");

        // 隶属叶子科目编号
        String titleNo = "";
        if (accountType == AccountTypeEnum.CUSTOMER.getValue()) {
            titleNo = "2001";
        } else if (accountType == AccountTypeEnum.MERCHANT.getValue()
                || accountType == AccountTypeEnum.AGENT.getValue()
                || accountType == AccountTypeEnum.POS.getValue()
                || accountType == AccountTypeEnum.POSAGENT.getValue()
                || accountType == AccountTypeEnum.POS_OUT_SETT.getValue()) {
            titleNo = "2002";
        } else if (accountType == AccountTypeEnum.PRIVATE.getValue()) {
            titleNo = "1002";
        }

        Account account = new Account();
        account.setUserNo(userNo);
        account.setAccountType(accountType);
        account.setAccountNo(accountNo);
        account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        account.setAccountTitleNo(titleNo);
        return accountDao.insert(account);
    }

    /**
     * 创建内部银行虚拟账户
     *
     * @param userNo
     * @param accountNo
     * @param balance
     * @param securityMoney
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) {
        logger.info("==>createPrivateAccount");

        // 隶属叶子科目编号
        String titleNo = "1002";

        Account account = new Account();
        account.setUserNo(userNo);
        account.setAccountNo(accountNo);
        account.setAccountType(AccountTypeEnum.PRIVATE.getValue());
        account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        account.setAccountTitleNo(titleNo);
        account.setBalance(balance);
        account.setSecurityMoney(securityMoney);
        return accountDao.insert(account);
    }

    /**
     * 账户状态变更操作
     *
     * @param userNo
     *         用户编号
     * @param operationType
     *         账户操作类型
     * @param initiator
     *         账户操作,发起方
     * @param desc
     *         变更操作说明
     */
    public void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc) {
        logger.info("==>changeAccountStatus");
        logger.info(String.format("==>userNo:%s, operationType:%s, initiator:%s, desc:%s", userNo, operationType.name(), initiator.name(), desc));

        Account account = accountDao.getByUserNo_IsPessimist(userNo, false);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.print();
        }

        if (operationType.equals(AccountOperationTypeEnum.FREEZE_DEBIT)) {
            account.setStatus(AccountStatusEnum.INACTIVE_FREEZE_DEBIT.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_DEBIT)) {
            account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.FREEZE_CREDIT)) {
            account.setStatus(AccountStatusEnum.INACTIVE_FREEZE_CREDIT.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_CREDIT)) {
            account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.FREEZE_ACCOUNT)) {
            account.setStatus(AccountStatusEnum.INACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_ACCOUNT)) {
            account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.CREATE_ACCOUNT)) {
            account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.FREEZE_FUND)) {
            account.setStatus(AccountStatusEnum.INACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.UNFREEZE_FUND)) {
            account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        } else if (operationType.equals(AccountOperationTypeEnum.CANCEL_ACCOUNT)) {
            account.setStatus(AccountStatusEnum.CANCELLED.getValue());
        }
        account.setLastTime(new Date());
        accountDao.update(account);

        AccountFrozenRecord accountFrozenRecord = new AccountFrozenRecord();
        accountFrozenRecord.setLastTime(new Date());
        accountFrozenRecord.setAccountNo(account.getAccountNo());
        accountFrozenRecord.setRemark(desc);
        accountFrozenRecord.setInitiator(initiator.getValue());
        accountFrozenRecord.setOperationType(operationType.getValue());
        accountFrozenRecordDao.insert(accountFrozenRecord);
    }

}

