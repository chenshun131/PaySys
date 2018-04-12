package com.chenshun.account.api.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 16:52  <p />
 * Version: V1.0  <p />
 * Description: 账户操作类型枚举 <p />
 */
public enum AccountOperationTypeEnum {

    /** 冻结止付 */
    FREEZE_DEBIT("冻结止付", 1),

    /** 解冻止付 */
    UNFREEZE_DEBIT("解冻止付", 2),

    /** 冻结止收 */
    FREEZE_CREDIT("冻结止收", 3),

    /** 解冻止收 */
    UNFREEZE_CREDIT("解冻止收", 4),

    /** 冻结账户 */
    FREEZE_ACCOUNT("冻结账户", 5),

    /** 解冻账户 */
    UNFREEZE_ACCOUNT("解冻账户", 6),

    /** 创建付款账户 */
    CREATE_ACCOUNT("创建付款账户", 7),

    /** 冻结资金 */
    FREEZE_FUND("冻结资金", 8),

    /** 解冻资金 */
    UNFREEZE_FUND("解冻资金", 9),

    /** 注销账户 */
    CANCEL_ACCOUNT("注销账户", 10);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private AccountOperationTypeEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountOperationTypeEnum getEnum(int value) {
        AccountOperationTypeEnum resultEnum = null;
        AccountOperationTypeEnum[] enumAry = AccountOperationTypeEnum.values();
        for (AccountOperationTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountOperationTypeEnum[] ary = AccountOperationTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>(ary.length);
        for (AccountOperationTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>(2);
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        AccountOperationTypeEnum[] ary = AccountOperationTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>(ary.length);
        for (AccountOperationTypeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>(2);
            map.put("value", anAry.toString());
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
