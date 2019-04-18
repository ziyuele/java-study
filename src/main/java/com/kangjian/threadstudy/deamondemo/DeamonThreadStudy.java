/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.threadstudy.deamondemo;

public class DeamonThreadStudy {

    public static void main(String args[]) throws Exception{
        // 后台线程派生的子线程都是后台线程
       Thread t = new Thread(new DeamonTheadTask());
       t.setDaemon(true);
       t.setPriority(Thread.MAX_PRIORITY);
       t.start();
       System.out.println(t.getPriority());
       Thread.sleep(100);
       System.out.println(t.isDaemon());
    }

}
