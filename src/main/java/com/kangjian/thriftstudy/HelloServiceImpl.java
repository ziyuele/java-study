package com.kangjian.thriftstudy;

import org.apache.thrift.async.AsyncMethodCallback;

public class HelloServiceImpl implements HelloService.AsyncIface {

    @Override
    public void hello(String name, AsyncMethodCallback resultHandler) {
        //resultHandler.onComplete("hahaha");
        System.out.println("this is a test");
    }
}

