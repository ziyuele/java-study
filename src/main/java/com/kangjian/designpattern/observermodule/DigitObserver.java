/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.observermodule;

public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println(this.getClass().getName());
        int count;
        for (int i = 0; i< numberGenerator.getNumber(); i ++) {
            System.out.println("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
