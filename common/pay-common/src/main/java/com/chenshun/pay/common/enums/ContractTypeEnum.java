package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:20 <p />
 * Version: V1.0  <p />
 * Description: 文件类型 : 1、商户文件；2、银行文件 <p />
 */
public enum ContractTypeEnum {

    MERCHANT("商户文件", 1),
    BANK("银行文件", 2);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private ContractTypeEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
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

    public static ContractTypeEnum getEnum(int value) {
        ContractTypeEnum resultEnum = null;
        ContractTypeEnum[] enumAry = ContractTypeEnum.values();
        for (ContractTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        ContractTypeEnum[] ary = ContractTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (ContractTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        ContractTypeEnum[] ary = ContractTypeEnum.values();
        List list = new ArrayList();
        for (ContractTypeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
