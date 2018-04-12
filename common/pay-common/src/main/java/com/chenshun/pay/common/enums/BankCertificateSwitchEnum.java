package com.chenshun.pay.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:15  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public enum BankCertificateSwitchEnum {
    OPEN("开启", 1), CLOSE("关闭", 2);

    private BankCertificateSwitchEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    private String desc;

    private int value;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static BankCertificateSwitchEnum getEnum(int value) {
        BankCertificateSwitchEnum resultEnum = null;
        BankCertificateSwitchEnum[] enumAry = BankCertificateSwitchEnum.values();
        for (BankCertificateSwitchEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        BankCertificateSwitchEnum[] ary = BankCertificateSwitchEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (BankCertificateSwitchEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

}
