package com.chenshun.pay.common.utils.httpclient;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * User: mew <p />
 * Time: 18/4/12 14:08  <p />
 * Version: V1.0  <p />
 * Description: 资源文件工具类 <p />
 */
public class ResourceUtils {

    private ResourceBundle resourceBundle;

    private ResourceUtils(String resource) {
        resourceBundle = ResourceBundle.getBundle(resource);
    }

    /**
     * 获取资源
     *
     * @param resource
     *         资源
     * @return 解析
     */
    public static ResourceUtils getResource(String resource) {
        return new ResourceUtils(resource);
    }

    /**
     * 根据key取得value
     *
     * @param key
     *         键值
     * @param args
     *         value中参数序列，参数:{0},{1}...,{n}
     * @return
     */
    public String getValue(String key, Object... args) {
        String temp = resourceBundle.getString(key);
        return MessageFormat.format(temp, args);
    }

    /**
     * 获取所有资源的Map表示
     *
     * @return 资源Map
     */
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>(resourceBundle.keySet().size());
        for (String key : resourceBundle.keySet()) {
            map.put(key, resourceBundle.getString(key));
        }
        return map;
    }

}
