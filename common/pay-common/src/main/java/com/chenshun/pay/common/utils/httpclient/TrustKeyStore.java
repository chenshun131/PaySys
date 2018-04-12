package com.chenshun.pay.common.utils.httpclient;

import javax.net.ssl.TrustManagerFactory;

/**
 * User: mew <p />
 * Time: 18/4/12 14:09  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class TrustKeyStore {

    private TrustManagerFactory trustManagerFactory;

    TrustKeyStore(TrustManagerFactory trustManagerFactory) {
        this.trustManagerFactory = trustManagerFactory;
    }

    TrustManagerFactory getTrustManagerFactory() {
        return trustManagerFactory;
    }

}
