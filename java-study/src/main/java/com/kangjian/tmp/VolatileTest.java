/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class VolatileTest {

    private static final int THRED_COUND = 20;
    private static volatile int count = 0;

    public static void increase() {
       count ++;
    }

    public static void main(String args[]) {
        Thread thread[] = new Thread[THRED_COUND];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(() -> {
                for (int x = 0; x < 1000; x++) {
                    increase();
                }
            });
            System.out.println("---");
            thread[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(count);

    }
}
