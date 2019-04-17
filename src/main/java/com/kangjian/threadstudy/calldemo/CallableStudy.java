/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.threadstudy.calldemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableStudy {

    public static void main(String args[]) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> res = service.submit(new CallDemo("test"));
        try {
            System.out.println("res is :" + res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
