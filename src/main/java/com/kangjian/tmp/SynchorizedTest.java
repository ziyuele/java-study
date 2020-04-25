/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.locks.ReentrantLock;

public class SynchorizedTest {

    private static final Object LOCK = new Object();

    public static synchronized void test() {
        System.out.println("test");
    }

    public synchronized void test1() {
        System.out.println("this is a test");
    }

    public void test2() {
        synchronized(LOCK) {
            System.out.println("this is a test");
        }
    }
}
