/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.threadstudy.joindemo;

public class JoinThreadTask implements Runnable{

    @Override
    public void run() {
       int x = 0;
       while (x < 3) {
           System.out.println("running time :" + x);
           x ++;
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
