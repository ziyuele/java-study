package com.kangjian.tmp;

public class tmp8 {

    public static final String s = "test";

    static {
        System.out.println("static block");
    }

    public static void main(String args[]) {
        System.out.println(tmp8.s);
    }
}
