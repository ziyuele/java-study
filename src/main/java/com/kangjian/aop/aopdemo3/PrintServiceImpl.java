/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo3;

public class PrintServiceImpl implements PrintService{

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
