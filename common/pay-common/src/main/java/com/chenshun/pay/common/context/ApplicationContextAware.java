package com.chenshun.pay.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 11:11  <p />
 * Version: V1.0  <p />
 * Description: 获取 Spring 上下文 <p />
 */
@Lazy(value = false)
@Component
public class ApplicationContextAware implements org.springframework.context.ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextAware.ctx = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

}
