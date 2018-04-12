package com.chenshun.pay.common.core.mybatis.cache.redis;

import org.apache.ibatis.cache.decorators.LoggingCache;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 16:25  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public class MybatiesRedisCache extends LoggingCache {

    public MybatiesRedisCache(String id) {
        super(new RedisCache(id));
    }

}
