package com.kangjian.tmp;

public class Tmp9 {

    /**
     *  从实现实现上将 str1 + str2  = new StringBuilder(str1).append(str2), 所以每次 + 的时候都会出现一个new StringBuilder
     *  的过程
     *
     *  但是在使用append 的时候， 没有出现new的过程， 这个是append比 + 快的根本原因
     *
     *  原理解释： https://blog.csdn.net/m0_37589327/article/details/78605268
     */


    public static void main(String args[]) {
        System.out.println(userAppend("test", 10000));
        System.out.println(useAdd("test", 10000));

    }

    public static long userAppend(String s, int num) {
        long time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < num; x ++) {
            sb.append(s);
        }
        return System.currentTimeMillis() - time;
    }


    public static long useAdd(String s, int num) {
        long time = System.currentTimeMillis();
        String ss = "";
        for(int x = 0; x < num; x ++) {
            ss += s;
        }
        return System.currentTimeMillis() - time;
    }
}
