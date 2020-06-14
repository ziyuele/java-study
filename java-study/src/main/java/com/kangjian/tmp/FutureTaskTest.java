/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// see at：https://zhuanlan.zhihu.com/p/102715466
public class FutureTaskTest {

    //1 实现callable
    public void test1() throws Exception{
        FutureTask<String> futureTask;
        futureTask = new FutureTask(new CallThreadTest());
        new Thread(futureTask).start();
        while (!futureTask.isDone()) {
            System.out.println("do something other in main thread, callable demo");
        }
        String ret = futureTask.get();
        System.out.println("ret is : " + ret);
    }

    //2 实现runnable, 并返回一个result
    public void test2() throws Exception {
        FutureTask<StringBuilder> futureTask;
        StringBuilder s = new StringBuilder();
        futureTask = new FutureTask(new RunnableTest(s), s);
        new Thread(futureTask).start();
        while (!futureTask.isDone()) {
            System.out.println("do something other in main thread, runnable demo");
        }
        StringBuilder ret = futureTask.get();
        System.out.println("ret is : " + ret);
    }

    class CallThreadTest implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2L);
            return "future test string";
        }
    }

    class RunnableTest implements Runnable {
        private StringBuilder s;
        public RunnableTest(StringBuilder s) {
            this.s = s;
        }
        @Override
        public void run() {
            s.append("Runnable Test");
        }
    }

    public static void main(String args[]) throws Exception  {
        FutureTaskTest taskTest = new FutureTaskTest();
        taskTest.test1();
        taskTest.test2();
    }


}
