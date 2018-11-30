package com.kangjian.designpattern.singletonmodule;

public class Singleton {
    private  static Singleton singleton = new Singleton();
    private Singleton(){
        System.out.println("this is a singleton");
    }

    public static Singleton getInstance(){
        return singleton;
    }
}
