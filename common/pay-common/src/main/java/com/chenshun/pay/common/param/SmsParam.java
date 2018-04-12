package com.chenshun.pay.common.param;

import java.io.Serializable;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:36  <p />
 * Version: V1.0  <p />
 * Description: 短信参数实体 <p />
 */
public class SmsParam implements Serializable {

    private static final long serialVersionUID = 6296401388735702975L;

    /** 接收短信的手机号码 */
    private String phone;

    /** 短信内容 */
    private String content;

    public SmsParam() {
        super();
    }

    public SmsParam(String phone, String content) {
        super();
        this.phone = phone;
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
