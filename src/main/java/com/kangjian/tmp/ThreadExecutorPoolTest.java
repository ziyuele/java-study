/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// see at: https://zhuanlan.zhihu.com/p/102715466
public class ThreadExecutorPoolTest {

    static class ThreadDemo implements Runnable{
        private StringBuilder stringBuilder;

        public ThreadDemo(StringBuilder stringBuilder) {
            this.stringBuilder = stringBuilder;
        }
        @Override
        public void run() {
           stringBuilder.append("V-A-L-U-E");
        }
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, 3, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), r -> {
                    Thread thread = new Thread(r);
                    thread.setName("hhhhh");
                    return thread;
                });
        // 1. threadPoolExecutor.excute(Runnable r);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("method run");
            }
        });


        // 2. threadPoolExecutor.submit(Callable r);
        Future<String> future = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "method call";
            }
        });
        System.out.println(future.get());


        // 3. threadPoolExecutor.submit(Runnable r， T result);
        StringBuilder s = new StringBuilder();
        Future<StringBuilder> future1 = threadPoolExecutor.submit(new ThreadDemo(s), s);
        System.out.println(future1.get());
        threadPoolExecutor.shutdown();
    }
}
