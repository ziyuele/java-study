/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo3;

public class Main {

    public static void main(String args[]) {
        PrintService printService = ProxyFactory.getInstance();
        printService.print("test");
    }
}
