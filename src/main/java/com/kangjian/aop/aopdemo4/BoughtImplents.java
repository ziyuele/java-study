/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo4;

public class BoughtImplents implements BoughtInterface {
    @Override
    public void getCar() {
       System.out.println("you get the car");
    }
}
