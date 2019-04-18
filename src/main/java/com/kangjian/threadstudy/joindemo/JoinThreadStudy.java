/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.threadstudy.joindemo;

public class JoinThreadStudy {
    public static void main(String args[]) throws InterruptedException {
       Thread t = new Thread(new JoinThreadTask());
       t.start();
       t.join();
       System.out.println("join action finished");
    }
}
