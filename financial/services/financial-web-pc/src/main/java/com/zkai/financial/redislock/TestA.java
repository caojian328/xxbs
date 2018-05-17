package com.zkai.financial.redislock;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-10-27 下午 4:48
 **/

public class TestA {
    public static void main(String[] args) throws Exception {

        JedisConnectionFactory redisConnectionFactory=new JedisConnectionFactory();
        redisConnectionFactory.setHostName("192.168.199.26");
        redisConnectionFactory.setPort(6379);
        redisConnectionFactory.setPassword("");
        redisConnectionFactory.setDatabase(13);
        redisConnectionFactory.setUsePool(true);
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        redisConnectionFactory.afterPropertiesSet();
        template.afterPropertiesSet();

        RedisLock lock = new RedisLock(template, "myRedisLock", 10000, 20000);
        try {
            if(lock.lock()) {
                //需要加锁的代码
                System.out.println("A locked...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //为了让分布式锁的算法更稳键些，
            // 持有锁的客户端在解锁之前应该再检查一次自己的锁是否已经超时，
            // 再去做DEL操作，因为可能客户端因为某个耗时的操作而挂起，            //操作完的时候锁因为超时已经被别人获得，这时就不必解锁了。 ————这里没有做
            lock.unlock();
            System.out.println("A unlock...");
        }

    }
}
