package com.chenshun.account.api.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 16:41  <p />
 * Version: V1.0  <p />
 * Description: 冻结资金操作类型 <p />
 */
public enum AccountFrozenHistoryTypeEnum {

    FROZEN("冻结", 123),
    UNFROZEN("解冻", 321);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    AccountFrozenHistoryTypeEnum(String desc, int value) {
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

    public static AccountFrozenHistoryTypeEnum getEnum(int value) {
        AccountFrozenHistoryTypeEnum resultEnum = null;
        AccountFrozenHistoryTypeEnum[] enumAry = AccountFrozenHistoryTypeEnum.values();
        for (AccountFrozenHistoryTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountFrozenHistoryTypeEnum[] ary = AccountFrozenHistoryTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>(ary.length);
        for (AccountFrozenHistoryTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>(2);
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        AccountFrozenHistoryTypeEnum[] ary = AccountFrozenHistoryTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (AccountFrozenHistoryTypeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", anAry.toString());
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
