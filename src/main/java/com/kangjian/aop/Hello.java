package com.kangjian.aop;

public class Hello implements IHello {
    @Override
    public void sayhello() {
        System.out.println("this is hello method");
    }
}
