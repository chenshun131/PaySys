package com.chenshun.pay.common.utils.httpclient;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 14:06  <p />
 * Version: V1.0  <p />
 * Description: JSON转换工具类 <p />
 */
public class JSONParseTools {

    public static Map<String, String> parseJSON2Map(String jsonStr) {
        Map<String, String> map = new HashMap<>();
        if (jsonStr == null || ("").equals(jsonStr.trim())) {
            return map;
        }
        // 最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            String v = json.get(k).toString();
            map.put(k.toString(), v);
        }
        return map;
    }

    public static void main(String[] args) {
        String str = "{\"version\":29999,\"description\":\"你好\",\"apkurl\":\"http://192.168.1.104:8080/mobilesafe2.0.apk\"}";
        Map<String, String> map = parseJSON2Map(str);
        System.out.println(map);
    }

}
