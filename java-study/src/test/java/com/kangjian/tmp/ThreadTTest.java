/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTTest {

    private final  Common comm = new Common();

    private Map<Integer, String> map = new HashMap();

    public void test() {
        System.out.println("this is a test");
    }

    @Test
    public void testContainsKey() throws Exception{
        for (int a = 0; a < 10000; a++) {
            map.put(a, "test");
        }

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int b = 0; b < 10000; b++) {
                        log.info(map.containsKey(b) + "");
                        map.remove(b);
                    }

                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                  map.entrySet().forEach(e -> {
                      try{
                         e.getValue();
                         Thread.sleep(100);
                      } catch (Exception e1) {
                          e1.printStackTrace();
                      }
                  });
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int x = 9999; x >= 0; x--) {
                        map.remove(x);
                    }
                    for (int a = 0; a < 10000; a++) {
                        map.put(a, "test");
                    }
                }
            }
        });
        t3.start();
        t2.start();
        t4.start();
        t3.join();
        t2.join();
    }

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

