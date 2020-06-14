/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class Tmp13 implements SignalHandler {
    @Override
    public void handle(Signal signal) {
        System.out.println(signal.toString());
    }

    public static void main(String args[]) throws Exception{

       Runtime.getRuntime().addShutdownHook(new Thread(() -> {
           System.out.println("System exit");
        }));
        while(true) {
            System.out.println("test");
            Thread.sleep(3 * 1000);
        }
    }
}
