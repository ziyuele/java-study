/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.eventBus;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

public class Main {

    private  static EventBus eventBus = new EventBus();
    private  static EventBus asyncEventBus = new AsyncEventBus(new ScheduledThreadPoolExecutor(18));

    public static void main(String args[]) {
        asyncEventBus.register(new Register());
        asyncEventBus.post(new Event());
        System.out.println("hahaha");
        eventBus.register(new Register());
        eventBus.post(new Event());
        System.out.println("hahaha");
    }
}
