package com.chenshun.pay.common.utils.httpclient;

/**
 * User: mew <p />
 * Time: 18/4/12 14:08  <p />
 * Version: V1.0  <p />
 * Description:
 * 把httpclient 发送请求的 方法封装成枚举类型
 * 这样可以避免字符串出错的情况
 * GET 代表法get 请求
 * POST代表发post 请求
 * 等等 <p />
 */
public enum MethodType {

    GET,
    POST,
    DELETE,
    PUT,
    TRACE,
    OPTION;

}
