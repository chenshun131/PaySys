package com.chenshun.pay.common.utils.httpclient;

import java.util.Map;

/**
 * User: mew <p />
 * Time: 18/4/12 14:03  <p />
 * Version: V1.0  <p />
 * Description: 属性文件中以拆分为 B2CPAY_URL 和 B2BPAY_URL <p />
 */
public class Context {

    public static String ORDERQUERY_URL;

    public static String REFUND_URL;

    public static String B2CPAY_URL;

    public static String B2BPAY_URL;

    public static String PAY_URL;

    public static String RETURN_URL;

    public static String NOTIFY_URL;

    public static String RECHARGE_URL;

    public static String WEB_TRADE_URL;

    static {
        Map<String, String> map = ResourceUtils.getResource("system").getMap();
        ORDERQUERY_URL = map.get("orderQueryUrl");
        REFUND_URL = map.get("refundUrl");
        B2CPAY_URL = map.get("B2CPayUrl");
        B2BPAY_URL = map.get("B2BPayUrl");
        PAY_URL = map.get("payUrl");
        RETURN_URL = map.get("returnUrl");
        NOTIFY_URL = map.get("notifyUrl");
        RECHARGE_URL = map.get("rechargeUrl");
        WEB_TRADE_URL = map.get("webTradeUrl");
    }

}
