/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class MaxStackTest {
    static long x = 0L;
    public static void main(String args[]) {
        getMaxStack(x);
    }

    public static void getMaxStack(long stack) {
            System.out.println("Stack size is:" +  (stack + 1));
            getMaxStack(stack + 1);
    }
}
