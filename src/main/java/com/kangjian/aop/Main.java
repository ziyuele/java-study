package com.kangjian.aop;

public class Main {

    public static void main(String args[]) {

        IHello hello = new HelloProxy(new Hello());
        hello.sayhello();

    }
}
