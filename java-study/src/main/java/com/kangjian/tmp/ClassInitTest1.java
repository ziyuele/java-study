/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class ClassInitTest1 {

    static class Parent {
        static {
            System.out.println("I am father class");
        }

        public static int value = 0;
    }

    static class Child extends Parent {
        static {
            System.out.println("I am child class");
        }

        public static int value = 0;
    }

    static class ConstClass {
        static {
            System.out.println("ConstClass test");
        }

        // 已经被记录到常量池里面去了
        public static final String string = "HELLO WRLD";
    }

    static class ConstClasNew {
        static {
            System.out.println("ConstClasNew test");
        }

        // 不会被记录到常量池里面去
        public static String string = "HELLO WRLD";
    }

    public static void main(String args[]) {
        // 1
        int num = Parent.value;
        // It will print "I am father class"

        // 2
        Child child[] = new Child[10];
        // "It will print nothing"

        // 3
        String s = ConstClass.string;
        // "It will print nothing"

        // 4
        s = ConstClasNew.string;
    }
}
