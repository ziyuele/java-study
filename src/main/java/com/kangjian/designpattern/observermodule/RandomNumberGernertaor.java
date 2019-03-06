/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.observermodule;

import java.util.Random;

public class RandomNumberGernertaor extends NumberGenerator{

    private Random random = new Random();
    private int number;
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 10; i++) {
            number = random.nextInt(20);
            notifyObersrvers();
        }
    }
}
