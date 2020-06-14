/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.study.oomtest;

public class StackOverFlowTest {


    public static void main(String args[]) {
       test();
    }

    public static void test() {
        test();
    }
}
