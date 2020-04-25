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
        Integer e = Integer.valueOf(1);
        Integer f = Integer.valueOf(1);
        System.out.println(e.hashCode());
        System.out.println(f.hashCode());
        System.out.println(e == f);

        long x  = -1L;
        System.out.println("==============");
        System.out.println(x == -1);
    }
}
