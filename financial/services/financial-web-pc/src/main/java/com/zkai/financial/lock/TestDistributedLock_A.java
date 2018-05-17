package com.zkai.financial.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-10-26 下午 3:29
 **/
public class TestDistributedLock_A {

    public static void main(String[] args) {

        final ZkClient zkClientExt = new ZkClient("localhost:2181", 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLockMutex mutex = new SimpleDistributedLockMutex(zkClientExt, "/Mutex");
        try {
            mutex.acquire();
            System.out.println("ClientA locked");
            Thread.sleep(600000);
            mutex.release();
            System.out.println("ClientA released lock");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}

