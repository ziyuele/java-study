/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    public static void main(String args[]) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
                3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }
}
