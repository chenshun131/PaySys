package com.chenshun.pay.common.utils.cache.redis.springimpl;

import com.chenshun.pay.common.utils.cache.redis.RedisUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * User: chenshun131 <p />
 * Time: 18/4/12 13:38  <p />
 * Version: V1.0  <p />
 * Description: 根据SPring API 自定义一个缓存类 ，实现Redis 缓存 <p />
 */
@Component("redisCache")
public class RedisCache implements Cache {

    /** 缓存的命名属性 */
    private String name;

    public RedisCache() {
    }

    public RedisCache(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 清空所有的缓存
     */
    @Override
    public void clear() {
        RedisUtils.flushAll();
    }

    @Override
    public void evict(Object key) {
        RedisUtils.del(key);
    }

    /**
     * 根据Key值获得缓存数据
     */
    public ValueWrapper get(Object key) {
        ValueWrapper result = null;
        Object thevalue = RedisUtils.get(key);
        if (thevalue != null) {
            result = new SimpleValueWrapper(thevalue);
        }
        return result;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return RedisUtils.getJedisSentinelPool();
    }

    /** 添加缓存 */
    @Override
    public void put(Object arg0, Object arg1) {
        RedisUtils.save(arg0, arg1, 20000);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

}
