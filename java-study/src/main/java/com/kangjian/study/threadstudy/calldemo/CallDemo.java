/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.threadstudy.calldemo;

import java.util.concurrent.Callable;

class CallDemo implements Callable<String> {
    private String name ;
    public CallDemo(String name) {
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        System.out.println(name);
        return name;
    }
}
