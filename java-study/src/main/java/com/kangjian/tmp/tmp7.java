package com.kangjian.tmp;

public class tmp7 {

    public static void main(String args[]) {
       System.out.println(Demo.s);
    }
}

class Demo {

    public static final String s = "test";

    static {
        System.out.println("static block");
    }
}
