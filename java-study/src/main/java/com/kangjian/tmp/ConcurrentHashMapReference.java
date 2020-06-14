/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapReference {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static volatile Map<String, A> map = new ConcurrentHashMap<>();

    private static A aa = new A();

    public static void main(String args[]) {
       ConcurrentHashMapReference reference =  new ConcurrentHashMapReference();
       map.put("test", new A());
       A ret = map.get("ddd");
       System.out.println(ret);
       Thread thread = new Thread(new TheadOne());
       Thread thread1 = new Thread(new ThreadTwo());
       thread.start();
       thread1.start();
        try {
            thread1.join();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get());
    }

    static class A {
        private int key;
        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    static class TheadOne implements Runnable {

        @Override
        public void run() {
            A a = aa;
            while (a.getKey() < 20) {
                System.out.print(a.getKey() + " ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.setKey(a.getKey() + 1);
                atomicInteger.getAndAdd(1);
            }
        }
    }


    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            A a = aa;
            while (a.getKey() < 20) {
                System.out.print(a.getKey() + " ");
                a.setKey(a.getKey() + 1);
                atomicInteger.getAndAdd(1);
            }
        }
    }

}
