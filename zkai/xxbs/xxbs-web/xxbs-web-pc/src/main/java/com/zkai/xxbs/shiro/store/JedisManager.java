package com.zkai.xxbs.shiro.store;

import com.zkai.common.serialize.SerializeUtil;
import com.zkai.xxbs.service.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import redis.clients.jedis.Jedis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Slf4j
public class JedisManager implements org.apache.shiro.cache.CacheManager{

    @Autowired
    @Qualifier(CacheService.cacheName)
    private CacheService cacheService;

    private static final int  expireTime = 60 * 30;

    private static final String SESSION_KEY_PREFIX = "xxbs_shiro_session:";
    private static final String REDIS_SHIRO_ALL = "*"+SESSION_KEY_PREFIX+"*";


    public void save(Session session) {

        String key = SESSION_KEY_PREFIX+session.getId().toString();
        String value = SerializeUtil.serialize(session);

        try {

            this.cacheService.put(key,value,expireTime);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    public Session get(String sid){

        Object result = null;
        try {

            sid = SESSION_KEY_PREFIX+sid;
            result = this.cacheService.get(sid);
            return SerializeUtil.deserialize(result.toString());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }

        return null;
    }

    public void delete(String sid) {

        try {
            sid = SESSION_KEY_PREFIX+sid;
            this.cacheService.delete(sid);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }



    /**
     * 获取所有Session
     * @return
     * @throws Exception
     */
    public Collection<Session> getAllSessions(){
        Jedis jedis = null;
        boolean isBroken = false;
        Set<Session> sessions = new HashSet<Session>();
       /* try {
            jedis = getJedis();
            jedis.select(dbIndex);

            Map<String, String> map = jedis.hgetAll(REDIS_SHIRO_ALL);
            for (Map.Entry<String, String> e : map.entrySet()){
                sessions.add(SerializeUtil.deserialize(e.getValue()));
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }*/
        return sessions;
    }


    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return null;
    }
}

