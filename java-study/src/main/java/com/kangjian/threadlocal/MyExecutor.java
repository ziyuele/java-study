package com.kangjian.threadlocal;

public class MyExecutor {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private String name = "kangjian";
    public void doSomeThing() {
        threadLocal.set(Thread.currentThread().getName() + "-kangjian");
        this.name = Thread.currentThread().getName() + "=threadName";
        //System.out.println(Thread.currentThread().getName() + " :Done");
    }

    public void getSomeThing() {
        String threadName = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ":" + threadName + "=== " + name);
    }

}
