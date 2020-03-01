/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class DeadLock {
    // 思路 A 有一把锁， 要抢B的锁, B 有一把锁， 要抢A的锁
    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
        System.out.println("Dead lock");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
            synchronized(LOCK_1) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK_2) {
                    System.out.println("it should not happened A");
                }
            }
        }
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            synchronized(LOCK_2) {
                try {
                    Thread.sleep(11);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK_1) {
                    System.out.println("it should not happened B");
                }
            }
        }
    }
}
