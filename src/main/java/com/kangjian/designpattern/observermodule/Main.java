/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.observermodule;

public class Main {
    public static void main(String args[]) {
        NumberGenerator numberGenerator = new RandomNumberGernertaor();

        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        numberGenerator.addObserver(observer1);
        numberGenerator.addObserver(observer2);

        numberGenerator.execute();
    }
}
