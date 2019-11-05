/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;

/**
 *  leetcode 415
 */
public class AddString {
    public String solution(String num1, String num2) {
        char []s1 = num1.toCharArray();
        char []s2 = num2.toCharArray();
        int x = 0;
        int addflag = 0;
        String ret = "";
        while (x < s1.length && x < s2.length) {
            ret = ((s1[s1.length -1 - x] + s2[s2.length - 1 - x] - '0' - '0') + addflag) % 10 + ret;
            addflag =( (s1[s1.length - 1 -x] + s2[s2.length - 1 - x] - '0' - '0')  + addflag) / 10;
            x ++;
        }
        while (x < s1.length) {
            ret = ((s1[s1.length - 1 - x] - '0')  + addflag) % 10 + ret;
            addflag = ((s1[s1.length - 1 - x] - '0')  + addflag) / 10;
            x++;
        }
        while (x < s2.length) {
            ret = ((s2[s2.length - 1 - x] - '0') + addflag  % 10) + ret;
            addflag = ((s2[s2.length - 1 - x] - '0') + addflag) / 10;
            x++;
        }
        if (addflag != 0) {
            ret = addflag + ret;
        }
        return ret;
    }
    public static void main(String args[]) {
        String num1 = "584";
        String num2 = "18";
        System.out.println(new AddString().solution(num1,num2));
    }
}
