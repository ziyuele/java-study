/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo4;

public class User {
    public static void main(String []args){
        CarsFactory factory = new CarsFactory();
        BoughtInterface instance = factory.getInstance();
        instance.getCar();
    }
}
