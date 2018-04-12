package com.chenshun.pay.common.utils.cache.redis.springimpl;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:38  <p />
 * Version: V1.0  <p />
 * Description: 继承了 spring1 内置的 AbstractCacheManager 管理 RedisCache 类缓存管理 <p />
 */
public class CacheManager<T extends Object> extends AbstractCacheManager {

    private Collection<? extends RedisCache> caches;

    public void setCaches(Collection<? extends RedisCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }

}
