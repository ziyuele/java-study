/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// see: https://zhuanlan.zhihu.com/p/103729904
public class FlowQPSControlTest {

    static final int MAX_CONCURR = 10;
    static Map<Long, Semaphore> currnMap = new HashMap<>();
    static Map<Long, AtomicInteger> curronIntegerMap = new HashMap<>();

    public static Semaphore getSemphore(Long timestamp) {
        if (!currnMap.containsKey(timestamp)) {
            synchronized(currnMap) {
                if (!currnMap.containsKey(timestamp)) {
                    currnMap.put(timestamp, new Semaphore(MAX_CONCURR));
                }
            }
        }
        return currnMap.get(timestamp);
    }

    public static AtomicInteger getAtomicInteger(Long timestamp) {
        if (!curronIntegerMap.containsKey(timestamp)) {
            synchronized(curronIntegerMap) {
                if (!curronIntegerMap.containsKey(timestamp)) {
                    curronIntegerMap.put(timestamp, new AtomicInteger(MAX_CONCURR));
                }
            }
        }
        return curronIntegerMap.get(timestamp);
    }

    public void doSemphoreJob() {
        long timestamp = System.currentTimeMillis() / 1000;
        Semaphore semaphore = getSemphore(timestamp);
        if (semaphore.tryAcquire()) {
            System.out.println("get executor value, left:" + semaphore.availablePermits());
        } else {
            System.err.println("Can not get value");
        }
        Thread.yield();
    }

    public void doAtomicIntegerJob() {
        long timestamp = System.currentTimeMillis() / 1000;
        AtomicInteger atomicInteger = getAtomicInteger(timestamp);
        int value = atomicInteger.get();
        if (value <= 0) {
            System.err.println("Can't get value, not execute");
            return;
        }
        if (atomicInteger.compareAndSet(value, value - 1)) {
            System.out.println("Get execute, current value:" + value);
        } else {
            System.err.println("Can't get value, not execute");
            return;
        }
    }

    public void testSemphore() {
        Thread t[] = new Thread[20];
        int x = 0;
        int y = 0;
        for (; x < t.length; x++) {
            t[x] = new Thread(() -> {
                doSemphoreJob();
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

    public void testAtomicInteger() {
        int x = 0;
        Thread thread[] = new Thread[100];
        for (; x < thread.length; x++) {
            thread[x] = new Thread(() -> {
                doAtomicIntegerJob();
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
        FlowQPSControlTest flowQPSControlTest = new FlowQPSControlTest();
        //flowQPSControlTest.testAtomicInteger();
        flowQPSControlTest.testSemphore();
    }
}
