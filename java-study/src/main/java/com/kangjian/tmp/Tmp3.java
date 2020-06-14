package com.kangjian.tmp;

/**
 *  ... function study
 */
public class Tmp3 {

    public static void main(String args []){
        test("test", "test1");
    }
    private static void test(String... num){
        for(String s: num){
            System.out.println(s);
        }
    }
}
