/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.statemodule;

public class Main {
    public static void main(String args[]) {
        StateFrame stateFrame = new StateFrame("state Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour ++) {
                stateFrame.setClock(hour);
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
