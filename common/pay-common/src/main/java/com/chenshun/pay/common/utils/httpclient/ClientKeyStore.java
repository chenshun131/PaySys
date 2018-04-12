package com.chenshun.pay.common.utils.httpclient;

import javax.net.ssl.KeyManagerFactory;

/**
 * User: mew <p />
 * Time: 18/4/12 14:03  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public class ClientKeyStore {

    private KeyManagerFactory keyManagerFactory;

    ClientKeyStore(KeyManagerFactory keyManagerFactory) {
        this.keyManagerFactory = keyManagerFactory;
    }

    KeyManagerFactory getKeyManagerFactory() {
        return keyManagerFactory;
    }

}
