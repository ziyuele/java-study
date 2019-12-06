/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {


    public static void main(String args[]) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask;
        futureTask = new FutureTask(new CallThreadTest());
        futureTask.run();
        System.out.println("try to get Execute ret");
        String ret = futureTask.get();
        System.out.println(ret);

    }

    static class CallThreadTest implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "qnmd";
        }
    }
}
