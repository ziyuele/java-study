/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;
import org.apache.curator.framework.recipes.locks.Lease;
import org.apache.curator.framework.recipes.shared.SharedCount;
import org.apache.curator.framework.recipes.shared.SharedCountListener;
import org.apache.curator.framework.recipes.shared.SharedCountReader;
import org.apache.curator.framework.recipes.shared.VersionedValue;
import org.junit.Test;

public class CuratorTest {

    @Test
    public void curatorTest() {
        RetryPolicy policy = new RetryPolicy() {
            @Override
            public boolean allowRetry(int retryCount, long elapsedTimeMs, RetrySleeper sleeper) {
                return false;
            }
        };
        CuratorFramework framework = CuratorFrameworkFactory.newClient("10.64.35.25:8181", policy);
        framework.start();


                InterProcessSemaphoreV2 lock = new InterProcessSemaphoreV2(framework, "/test", 2);
        InterProcessSemaphoreV2 lock1 = new InterProcessSemaphoreV2(framework, "/test", 2);
        InterProcessSemaphoreV2 lock2 = new InterProcessSemaphoreV2(framework, "/test", 2);
                try {
                    //Lease lease = lock.acquire(2, TimeUnit.SECONDS);
                    //lock1.acquire(2, TimeUnit.SECONDS);
                    Lease lease2 = lock2.acquire(3, TimeUnit.SECONDS);
                    System.out.println(lock2.getParticipantNodes().size());
                    Thread.sleep(30000);
                    System.out.println(lock2.getParticipantNodes().size());
                    lock.returnLease(lease2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                List<String> lockPaht = new ArrayList<>();
//                lockPaht.add("/test");
//                InterProcessMultiLock lock = new InterProcessMultiLock(framework, lockPaht);
//                try {
//                    lock.acquire(2, TimeUnit.SECONDS);
//                    Thread.sleep(30000);
//                    lock.release();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//        InterProcessMutex lock = new InterProcessMutex(framework, "/test");
//        try {
//                                lock.acquire(2, TimeUnit.SECONDS);
//                                Thread.sleep(30000);
//                                lock.release();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//         }
    }
    @Test
    public void curatorTest1() {
        RetryPolicy policy = new RetryPolicy() {
            @Override
            public boolean allowRetry(int retryCount, long elapsedTimeMs, RetrySleeper sleeper) {
                return false;
            }
        };
        CuratorFramework framework = CuratorFrameworkFactory.newClient("10.64.35.25:8181", policy);
        framework.start();
        framework.create();
    }
}
