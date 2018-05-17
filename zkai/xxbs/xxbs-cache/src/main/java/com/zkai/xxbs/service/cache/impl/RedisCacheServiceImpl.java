package com.zkai.xxbs.service.cache.impl;

import com.zkai.xxbs.service.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * 缓存服务接口实现
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-26 上午 11:39
 **/
@Slf4j
@Service(CacheService.cacheName)
public class RedisCacheServiceImpl implements CacheService {

    @Autowired
    private JedisPool jedisPool;

    private static final int dbIndex = 10;

    private Jedis getJedis() throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(dbIndex);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            throw new JedisConnectionException(e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return jedis;
    }

    @Override
    public void put(Object key, Object value) throws Exception {
        this.put(key,value,0);
    }

    @Override
    public void put(Object key, Object value, int expireTime) throws Exception {

        Jedis jedis = getJedis();
        try {
            if (key instanceof String) {
                jedis.set(key.toString(), value.toString());
                if(expireTime>0){
                    jedis.expire(key.toString(), expireTime);
                }

            } else if (key instanceof byte[]) {
                jedis.set((byte[]) key, (byte[]) value);
                if(expireTime>0){
                    jedis.expire((byte[]) key, expireTime);
                }
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Object get(Object key) throws Exception {
        Jedis jedis = getJedis();
        try {
            if (key instanceof String) {
                return jedis.get(key.toString());
            } else if (key instanceof byte[]) {
                return jedis.get((byte[]) key);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }


    @Override
    public void delete(Object key) throws Exception {
        Jedis jedis = getJedis();
        try {
            if (key instanceof String) {
                jedis.del(key.toString());
            } else if (key instanceof byte[]) {
                jedis.del((byte[]) key);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
