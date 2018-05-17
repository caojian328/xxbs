package com.zkai.xxbs.service.cache;

/**
 * 缓存服务接口
 * @Author 曹健【115359178@qq.com】
 * @Date by 2017/6/26 0026 上午 11:38
 */
public interface CacheService {

    String cacheName = "redisCacheServiceImpl";

    void put(Object key,Object value)throws Exception;

    void put(Object key,Object value,int expireTime)throws Exception;

    Object get(Object key)throws Exception;

    void delete(Object key)throws Exception;


}
