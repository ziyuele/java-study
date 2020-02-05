/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class IntegerTest {

    public static void main(String args[]) {
        Integer a = 3;
        Integer b = 3;
        // 自动拆箱
        System.out.println(a == b);
        Integer c = 1999;
        Integer d = 1999;

        System.out.println(c == d);

    }
}
