/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.CountDownLatch;

public class LogTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String args[]) {
        int threadNum = 5;
        for (int x = 0; x < threadNum; x++) {
            System.out.println("Start thread:" + x);
            if (x == threadNum -1) {
                System.out.println("ALL Thread Init Ok, working");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new TestThread()).start();
            countDownLatch.countDown();
        }

    }

    static class TestThread implements Runnable {
        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RUNNING:" + Thread.currentThread().getName());
        }
    }
}
