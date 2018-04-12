package com.chenshun.pay.common.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 11:9  <p />
 * Version: V1.0  <p />
 * Description: 接口类型 <p />
 */
public enum CmdType {

    B2C {
        @Override
        public String getDesc() {
            return "B2C";
        }
    },
    B2B {
        @Override
        public String getDesc() {
            return "B2B";
        }
    },

    Buy {
        @Override
        public String getDesc() {
            return "订单创建";
        }
    },
    OrderQuery {
        @Override
        public String getDesc() {
            return "订单查询";
        }
    },
    OrderRefund {
        @Override
        public String getDesc() {
            return "订单退款";
        }
    };

    public static Map<String, String> toStringMap() {
        CmdType[] type = values();
        Map<String, String> map = new LinkedHashMap<>();
        for (CmdType e : type) {
            map.put(e.toString(), e.getDesc());
        }
        return map;
    }

    public abstract String getDesc();

}
