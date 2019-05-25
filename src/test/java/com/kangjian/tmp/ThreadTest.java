/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTest {

    private final  Common comm = new Common();

    @Test
    public void testSynchronizeMethod() {
       Thread t1 = new Thread(new Runnable() {
           @Override
           public void run() {
               comm.method();
           }
       });
       t1.setName("test-1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                comm.method();
            }
        });
        t2.setName("test-2");
        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("two thread will run together");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                comm.method1();
            }
        });
        t3.setName("test-3");

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                comm.method1();
            }
        });
        t4.setName("test-4");
        t3.start();
        t4.start();
        try {
            t3.join();
            log.info("thread 3 run over");
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class Common {

        public void method() {
            log.info("thread name is :" +  Thread.currentThread().getName());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void  method1() {
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("thread name is :" +  Thread.currentThread().getName());
        }
    }
}

