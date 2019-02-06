package com.kangjian.aop;

public class HelloProxy implements IHello {

    private IHello hello;

    public HelloProxy(IHello hello) {
        this.hello = hello;
    }

    @Override
    public void sayhello() {
        System.out.println("this is pre stout");
        hello.sayhello();
        System.out.println("this is post stdout");
    }
}
