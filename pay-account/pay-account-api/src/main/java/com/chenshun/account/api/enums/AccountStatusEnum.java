package com.chenshun.account.api.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 16:54  <p />
 * Version: V1.0  <p />
 * Description: 账户状态. 适用于账户表 <p />
 */
public enum AccountStatusEnum {

    ACTIVE("激活", 100),
    INACTIVE("冻结", 101),
    INACTIVE_FREEZE_CREDIT("冻结止收", 102),
    INACTIVE_FREEZE_DEBIT("冻结止付", 103),
    CANCELLED("注销", 104);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private AccountStatusEnum(String desc, int value) {
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

    public static AccountStatusEnum getEnum(int value) {
        AccountStatusEnum resultEnum = null;
        AccountStatusEnum[] enumAry = AccountStatusEnum.values();
        for (AccountStatusEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountStatusEnum[] ary = AccountStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>(ary.length);
        for (AccountStatusEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>(2);
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        AccountStatusEnum[] ary = AccountStatusEnum.values();
        List<Map<String, String>> list = new ArrayList<>(ary.length);
        for (AccountStatusEnum anAry : ary) {
            Map<String, String> map = new HashMap<>(2);
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

    /**
     * 只要冻结，冻结止收，冻结止付3种状态
     *
     * @return
     */
    public static List toAccountStatusList() {
        AccountStatusEnum[] ary = AccountStatusEnum.values();
        List<Map<String, String>> list = new ArrayList<>(ary.length);
        int value[] = {101, 102, 103};
        for (AccountStatusEnum anAry : ary) {
            int val = anAry.getValue();
            for (int v : value) {
                if (val == v) {
                    Map<String, String> map = new HashMap<>(2);
                    map.put("value", String.valueOf(val));
                    map.put("desc", anAry.getDesc());
                    list.add(map);
                }
            }
        }
        return list;
    }

}