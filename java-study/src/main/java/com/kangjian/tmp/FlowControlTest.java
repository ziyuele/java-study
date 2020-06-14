/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// see: https://zhuanlan.zhihu.com/p/103729904
public class FlowControlTest {

    static Semaphore semaphore = new Semaphore(10);
    static AtomicInteger atomicInteger = new AtomicInteger(10);

    void doSemaphoreJob() {
        if (semaphore.tryAcquire()) {
            try {
                System.out.println("get executor value, left:" + semaphore.availablePermits());
            } finally {
                semaphore.release();
            }
        } else {
            System.out.println("Can not get value");
            return;
        }
    }

    void testSemaphore() {
        Thread t[] = new Thread[20];
        int x = 0;
        int y = 0;
        for (; x < t.length; x++) {
            t[x] = new Thread(() -> {
                doSemaphoreJob();
            });
            t[x].start();
        }
        for (; y < t.length; y++) {
            try {
                t[y].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void doCounterJob() {
        int value = atomicInteger.get();
        if (value <= 0) {
            System.err.println("Can't get value, not execute");
            return;
        }
        if (atomicInteger.compareAndSet(value, value - 1)) {
            System.out.println("Get execute, current value:" + value);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Can't get value, not execute");
            return;
        }
        atomicInteger.incrementAndGet();
    }

    void testCounter() {
        int x = 0;
        Thread thread[] = new Thread[100];
        for (; x < thread.length; x++) {
            thread[x] = new Thread(() -> {
                doCounterJob();
            });
            thread[x].start();
        }

        for (Thread t : thread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        //FlowControlTest flowControlTest = new FlowControlTest();
        // flowControlTest.testSemaphore();
        //flowControlTest.testCounter();
        Semaphore s = new Semaphore(10);
        s.release();
        System.out.println(s.availablePermits());
    }
}
