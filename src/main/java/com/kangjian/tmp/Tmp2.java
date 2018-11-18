package com.kangjian.tmp;

/**
 * integer Max Value study
 */

public class Tmp2 {
    public static void main(String args[]){
        int a = Integer.MAX_VALUE;
        int x = 0x7FFFFFFF;
        System.out.println(x);
        System.out.println(a);
        long b = a + 1;
        System.out.println(b);
        long c = (long)a + 1;
        System.out.println(c);
    }
}

