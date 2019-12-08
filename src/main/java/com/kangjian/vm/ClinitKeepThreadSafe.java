/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.vm;

public class ClinitKeepThreadSafe {

    static class Demo {
        static {
            if (true) {
                System.out.println(Demo.class.getName() + " try to Init");
                while ( true ) {
                }
            }
        }
    }

    static class ThreadRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("thread : " + Thread.currentThread().getName() + " init");
            new Demo();
            System.out.println("thread : " + Thread.currentThread().getName() + " init Over");
        }
    }

    public static void main(String args[]) {
        // 静态代码块只更新一次， 两条线程都不会结束， 等待hang住
        new Thread(new ThreadRunnable(), "hhh").start();
        new Thread(new ThreadRunnable(), "aaa").start();
    }
}
