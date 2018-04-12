package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:21 <p />
 * Version: V1.0  <p />
 * Description: 投诉与建议 帮助类型枚举 <p />
 */
public enum HelpTypeEnum {

    COMPLAINT("投诉", 41),
    LOGIN("登录注册", 42),
    TRANSFER_ACCOUNTS("转账", 43),
    RECHARGE("充值", 44),
    WITHDRAW_DEPOSIT("提现", 45),
    SETTLE_ACCOUNTS("结算", 46),
    AUTONYM("实名认证", 47),
    DC("数字证书", 49),
    PASSWORD_MANAGEMENT("密码管理", 50),
    MOBILE_PHONE("手机绑定", 51),
    EMAIL("邮箱绑定", 52),
    OTHER("其他", 53);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private HelpTypeEnum(String desc, int value) {
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

    public static HelpTypeEnum getEnum(int value) {
        HelpTypeEnum resultEnum = null;
        HelpTypeEnum[] enumAry = HelpTypeEnum.values();
        for (HelpTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        HelpTypeEnum[] ary = HelpTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (HelpTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        HelpTypeEnum[] ary = HelpTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (HelpTypeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

    /**
     * 取枚举的json字符串
     *
     * @return
     */
    public static String getJsonStr() {
        HelpTypeEnum[] enums = HelpTypeEnum.values();
        StringBuilder jsonStr = new StringBuilder("[");
        for (HelpTypeEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'")
                    .append(senum.toString())
                    .append("',desc:'")
                    .append(senum.getDesc())
                    .append("',value:'")
                    .append(senum.getValue())
                    .append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
