/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;


public class LongestPalindrome {

    public static String logestString(String s) {
        String ret = "";
        for (int a = 0; a < s.length(); a++) {
            for (int b = a; b <= s.length(); b++) {
                String tmp = s.substring(a, b);
                String tmp1 = new StringBuilder(tmp).reverse().toString();
                if (tmp.equals(tmp1)) {
                    ret = ret.length() > tmp.length() ? ret : tmp;
                }
            }
        }
        return ret;
    }


    static String looggestString1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start= 0;
        int end = 0;
        for (int x = 0; x< s.length(); x ++) {
            int lena = getLoggestSize(s, x, x);
            int lenb = getLoggestSize(s, x, x+1);
            int ret = Math.max(lena, lenb);
            if (ret > (end - start)) {
               start = x - (ret -1 ) / 2;
               end = x + ret / 2;
            }
        }
        return s.substring(start, end);
    }

    static int getLoggestSize(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
        }
        return right - left - 1;
    }

    public static void main(String [] args) {
        String s = "a";
        String ret = logestString(s);
        System.out.println(ret);
    }

}
