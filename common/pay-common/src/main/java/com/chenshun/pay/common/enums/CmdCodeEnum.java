package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:18  <p />
 * Version: V1.0  <p />
 * Description: API接口，对应编号 <p />
 */
public enum CmdCodeEnum {

    RECHARGE("充值", 1001),
    REFUND("退款", 1002),
    ONLINE_B2C_ACQUIRING("在线B2C收款", 1003),
    ONLINE_B2B_ACQUIRING("在线B2B收款", 1004),
    QUERY_PAYMENT_ORDER("支付订单查询", 1004),
    QUERY_REFUND("退款订单查询", 1005),
    MOBILE_ACQUIRING("移动收单", 1006),
    POS_ACQUIRING("POS收单", 1007),
    ICC_ACQUIRING("外卡收单", 1008),
    ACCOUNT_AGENCYDEBIT("代扣", 1009);

    /** 描述 */
    private String desc;

    /** 枚举值 */
    private int value;

    /** 构造函数 */
    private CmdCodeEnum(String desc, int value) {
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

    public static CmdCodeEnum getEnum(int value) {
        CmdCodeEnum resultEnum = null;
        CmdCodeEnum[] enumAry = CmdCodeEnum.values();
        for (CmdCodeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        CmdCodeEnum[] ary = CmdCodeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (CmdCodeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        CmdCodeEnum[] ary = CmdCodeEnum.values();
        List list = new ArrayList();
        for (CmdCodeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

}
