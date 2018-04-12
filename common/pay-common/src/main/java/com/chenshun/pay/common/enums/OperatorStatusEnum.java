package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:23 <p />
 * Version: V1.0  <p />
 * Description: 操作员状态 <br/>
 * 适用于表：
 * TBL_BOSS_OPERATOR，
 * TBL_MERCHANT_OPERATOR
 * <p/>
 */
public enum OperatorStatusEnum {

    ACTIVE("激活", 100),
    INACTIVE("冻结", 101);

    /** 描述 */
    private String desc;

    /** 枚举值 */
    private int value;

    private OperatorStatusEnum(String desc, int value) {
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

    public static OperatorStatusEnum getEnum(int value) {
        OperatorStatusEnum resultEnum = null;
        OperatorStatusEnum[] enumAry = OperatorStatusEnum.values();
        for (OperatorStatusEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        OperatorStatusEnum[] ary = OperatorStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (OperatorStatusEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        OperatorStatusEnum[] ary = OperatorStatusEnum.values();
        List list = new ArrayList();
        for (OperatorStatusEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
