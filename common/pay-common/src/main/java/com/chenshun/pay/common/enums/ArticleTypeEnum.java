package com.chenshun.pay.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 11:43  <p />
 * Version: V1.0  <p />
 * Description: 文章类型枚举 <p />
 */
public enum ArticleTypeEnum {

    ARTICLE("企业动态", 1),
    RECRUITMENT("招聘信息", 2),
    ASKEDQUESTION("常见问题", 3),
    PRODUCT("产品发布", 4),
    NOTICE("公告/通知", 5);

    /** 枚举值 */
    private int value;

    /** 描述 */
    private String desc;

    private ArticleTypeEnum(String desc, int value) {
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

    public static ArticleTypeEnum getEnum(int value) {
        ArticleTypeEnum resultEnum = null;
        ArticleTypeEnum[] enumAry = ArticleTypeEnum.values();
        for (ArticleTypeEnum anEnumAry : enumAry) {
            if (anEnumAry.getValue() == value) {
                resultEnum = anEnumAry;
                break;
            }
        }
        return resultEnum;
    }

    public static List toList() {
        ArticleTypeEnum[] ary = ArticleTypeEnum.values();
        List list = new ArrayList();
        for (ArticleTypeEnum anAry : ary) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            list.add(map);
        }
        return list;
    }

    public static Map<String, Map<String, Object>> toMap() {
        ArticleTypeEnum[] ary = ArticleTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (ArticleTypeEnum anAry : ary) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(anAry.getValue()));
            map.put("value", String.valueOf(anAry.getValue()));
            map.put("desc", anAry.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    /**
     * 取枚举的json字符串
     *
     * @return
     */
    public static String getJsonStr() {
        ArticleTypeEnum[] enums = ArticleTypeEnum.values();
        StringBuilder jsonStr = new StringBuilder("[");
        for (ArticleTypeEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum.toString()).append("',desc:'").append(senum.getDesc())
                    .append("',value:'").append(senum.getValue()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
