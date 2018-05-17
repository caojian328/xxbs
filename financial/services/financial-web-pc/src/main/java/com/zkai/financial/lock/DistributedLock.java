package com.zkai.financial.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-10-26 下午 3:15
 **/
public interface DistributedLock {

    /**获取锁，如果没有得到就等待*/
    public  void acquire() throws Exception;

    /**
     * 获取锁，直到超时
     * @param time 超时时间
     * @param unit time参数的单位
     * @return是否获取到锁
     * @throws Exception
     */
    public  boolean acquire (long time, TimeUnit unit)  throws Exception;

    /**
     * 释放锁
     * @throws Exception
     */
    public  void release()  throws Exception;
}