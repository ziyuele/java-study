/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.CountDownLatch;

public class CountDownLanchTest {
    static final CountDownLatch countDownLatch = new CountDownLatch(2);

    class ThreadOne implements Runnable  {
        @Override
        public void run() {
            System.out.println("Try to start one thread");
            countDownLatch.countDown();
        }
    }

    class ThreadTwo implements Runnable {

        @Override
        public void run() {
            System.out.println("Try to start two thread");
            countDownLatch.countDown();
        }
    }

    public void doTest() {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
    }

    public static void main(String args[]) throws InterruptedException {
       new CountDownLanchTest().doTest();
       countDownLatch.await();
    }


}
