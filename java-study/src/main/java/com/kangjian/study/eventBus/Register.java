/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.eventBus;

import com.google.common.eventbus.Subscribe;

public class Register {

    @Subscribe
    public void executeEvent(Event event) throws Exception {
       event.runEvent();
       Thread.sleep(10000);
    }
}
