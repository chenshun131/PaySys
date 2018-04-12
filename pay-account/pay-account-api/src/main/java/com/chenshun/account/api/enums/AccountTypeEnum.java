package com.chenshun.account.api.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 16:58  <p />
 * Version: V1.0  <p />
 * Description: 账户类型 . 适用于账户表 <p />
 */
public enum AccountTypeEnum {

    MERCHANT("在线商户", 1),
    AGENT("代理商", 2),
    CUSTOMER("个人/会员", 3),
    PRIVATE("内部账户", 4),
    POS("POS商户", 5),
    POSAGENT("POS代理商", 6),
    POS_OUT_SETT("POS商户_外部结算", 7);

    /** 描述 */
    private String desc;

    /** 枚举值 */
    private int value;

    private AccountTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 根据枚举值获取枚举属性
     *
     * @param value
     *         枚举值
     * @return enum 枚举属性
     */
    public static AccountTypeEnum getEnum(int value) {
        AccountTypeEnum resultEnum = null;
        AccountTypeEnum[] enumAry = AccountTypeEnum.values();
        for (AccountTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    /**
     * 将枚举类转换为map
     *
     * @return Map&lt;key, Map&lt;attr, value>>
     */
    public static Map<String, Map<String, Object>> toMap() {
        AccountTypeEnum[] ary = AccountTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>(ary.length);
        for (AccountTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>(2);
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", anAry.getValue());
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    /**
     * 将枚举类转换为list
     *
     * @return List&lt;Map&lt;String, Object>> list
     */
    public static List<Map<String, Object>> toList() {
        AccountTypeEnum[] ary = AccountTypeEnum.values();
        List<Map<String, Object>> list = new ArrayList<>(ary.length);
        for (AccountTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>(2);
            map.put("value", anAry.getValue());
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
