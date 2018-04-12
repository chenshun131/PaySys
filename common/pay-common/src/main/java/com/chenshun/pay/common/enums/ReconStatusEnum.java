package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:31 <p />
 * Version: V1.0  <p />
 * Description: 对账状态 <br/>
 * 适用于表：TBL_ACCOUNTING_REQUEST_NOTE <p />
 */
public enum ReconStatusEnum {

    INIT("未对账", 100),
    SUCCESS("已对账", 101),
    NOT_RECON("不对账", 102);

    /** 描述 */
    private String desc;

    /** 枚举值 */
    private int value;

    private ReconStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
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

    public static ReconStatusEnum getEnum(int value) {
        ReconStatusEnum resultEnum = null;
        ReconStatusEnum[] enumAry = ReconStatusEnum.values();
        for (ReconStatusEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        ReconStatusEnum[] ary = ReconStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (ReconStatusEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        ReconStatusEnum[] ary = ReconStatusEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (ReconStatusEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
