/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.vm;

public class ClassLoadCheck {

    static interface InterfaceA {
        static int a = 10;
    }

    static interface InterfaceB extends InterfaceA {
        static int a = 11;
    }

    static class TestClass implements InterfaceA {
        //public static int a = 11;
    }

    static class TestClassHH extends TestClass implements InterfaceB {

    }

    public static void main(String args[]) {
        // compile reject
        //System.out.println(TestClassHH.a);
    }
}
