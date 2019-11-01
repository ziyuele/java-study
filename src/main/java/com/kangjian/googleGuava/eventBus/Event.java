/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.googleGuava.eventBus;

import com.google.common.eventbus.Subscribe;

public class Event {

    public Object runEvent() {
        System.out.println("tried to run Event");
        return null;
    }
}
