package com.chenshun.pay.common.utils.httpclient;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: mew <p />
 * Time: 18/4/12 14:06  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public interface HttpResponseCallBack {

    void processResponse(InputStream responseBody) throws IOException;

}
