/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class TestThreadPool {

    static  ThreadPoolExecutor threadPoolExecutor;
    public static void main(String args[]) throws InterruptedException {
        TestThreadPool testThreadPool = new TestThreadPool();
        threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                120L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("instance-deploy-%s").build(),
                new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
               throw new RuntimeException("pool is Full");
            }
        });
       for (int x = 1; x < 10; x++ ) {
           System.out.println(x);
           Thread thread = new Thread(() -> {
               try {
                   Thread.sleep(1);
                   System.out.println("test" + Thread.currentThread());
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
           try {

               threadPoolExecutor.execute(thread);
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
       System.out.println(threadPoolExecutor.getActiveCount());
       Thread.sleep(3);
       System.out.println(threadPoolExecutor.getActiveCount());
       threadPoolExecutor.shutdown();
    }
}
