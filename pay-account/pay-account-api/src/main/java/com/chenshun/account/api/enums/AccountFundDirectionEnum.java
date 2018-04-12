package com.chenshun.account.api.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 16:48  <p />
 * Version: V1.0  <p />
 * Description: 账户资金变动方向 <p />
 */
public enum AccountFundDirectionEnum {

    /** 加款 */
    ADD("加款", 123),

    /** 减款 */
    SUB("减款", 321),

    /** 冻结 */
    FROZEN("冻结", 321),

    /** 解冻 */
    UNFROZEN("解冻", 123);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private AccountFundDirectionEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "value=" + this.value + " desc=" + this.desc;
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

    public static AccountFundDirectionEnum getEnum(int value) {
        AccountFundDirectionEnum resultEnum = null;
        AccountFundDirectionEnum[] enumAry = AccountFundDirectionEnum.values();
        for (AccountFundDirectionEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountFundDirectionEnum[] ary = AccountFundDirectionEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>(ary.length);
        for (AccountFundDirectionEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>(2);
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        AccountFundDirectionEnum[] ary = AccountFundDirectionEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (AccountFundDirectionEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", anAry.toString());
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
