/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public static void main(String args[]) {
       ConditionTest conditionTest =  new ConditionTest();
       new Thread(conditionTest.new Thread1()).start();
       new Thread(conditionTest.new Thread2()).start();
    }

    class Thread1 implements Runnable {
        @Override
        public void run() {
            reentrantLock.lock();
            try {
                condition.await();
                System.out.println("this is a test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            reentrantLock.lock();
            condition.signal();
            System.out.println("singal");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }
    }
}
