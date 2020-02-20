/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.threadstudy.deamondemo;

public class DeamonTheadTask implements Runnable {

    @Override
    public void run() {
        System.out.println("this is a deamon thread");
    }
}
