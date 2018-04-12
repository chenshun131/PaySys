package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:23 <p />
 * Version: V1.0  <p />
 * Description: 操作员类型 <br/>
 * 适用于表：
 * TBL_BOSS_OPERATOR，
 * TBL_MERCHANT_OPERATOR
 * <p/>
 */
public enum OperatorTypeEnum {

    ADMINISTRATOR("管理员", 1),
    USER("普通用户", 0);

    /** 描述 */
    private String desc;

    /** 枚举值 */
    private int value;

    private OperatorTypeEnum(String desc, int value) {
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

    public static OperatorTypeEnum getEnum(int value) {
        OperatorTypeEnum resultEnum = null;
        OperatorTypeEnum[] enumAry = OperatorTypeEnum.values();
        for (OperatorTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        OperatorTypeEnum[] ary = OperatorTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (OperatorTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        OperatorTypeEnum[] ary = OperatorTypeEnum.values();
        List list = new ArrayList();
        for (OperatorTypeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
