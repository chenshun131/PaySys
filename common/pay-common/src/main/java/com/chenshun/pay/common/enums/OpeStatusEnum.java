package com.chenshun.pay.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:20 <p />
 * Version: V1.0  <p />
 * Description: 日志操作枚举 <p />
 */
public enum OpeStatusEnum {

    SUCCESS("操作成功", 100), FAIL("操作失败", 101);

    /** 存贮值 */
    private Integer value;

    /** 显示值 */
    private String label;

    private OpeStatusEnum(String label, Integer value) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static OpeStatusEnum getEnum(int value) {
        OpeStatusEnum resultEnum = null;
        OpeStatusEnum[] enumAry = OpeStatusEnum.values();
        for (OpeStatusEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        OpeStatusEnum[] ary = OpeStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (OpeStatusEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("label", anAry.getLabel());
            enumMap.put(key, map);
        }
        return enumMap;
    }

}
