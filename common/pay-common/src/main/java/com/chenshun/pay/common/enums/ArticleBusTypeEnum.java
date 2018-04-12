package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 11:43  <p />
 * Version: V1.0  <p />
 * Description: 文章业务类型 <p />
 */
public enum ArticleBusTypeEnum {

    ONLINE("在线", 1), POS("POS", 2);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private ArticleBusTypeEnum(String desc, int value) {
        this.value = value;
        this.desc = desc;
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

    public static ArticleBusTypeEnum getEnum(int value) {
        ArticleBusTypeEnum resultEnum = null;
        ArticleBusTypeEnum[] enumAry = ArticleBusTypeEnum.values();
        for (ArticleBusTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static List toList() {
        ArticleBusTypeEnum[] ary = ArticleBusTypeEnum.values();
        List list = new ArrayList();
        for (ArticleBusTypeEnum anAry : ary) {
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
        ArticleBusTypeEnum[] enums = ArticleBusTypeEnum.values();
        StringBuilder jsonStr = new StringBuilder("[");
        for (ArticleBusTypeEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum.toString()).append("',desc:'").append(senum.getDesc())
                    .append("',value:'").append(senum.getValue()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

    public static Map<String, Map<String, Object>> toMap() {
        ArticleBusTypeEnum[] ary = ArticleBusTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (ArticleBusTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

}
