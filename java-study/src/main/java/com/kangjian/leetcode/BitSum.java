/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;


/**
 *  二进制求和 67
 */
public class BitSum {

    // group one
    private String sumA = "11";
    private String sumB = "1";

    // group two
    private String sumC = "1010";
    private String sumD = "1011";

    public String solution(String a, String b) {
        String res ="";
        int addNum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (a.length() > b.length()) {
           addNum = a.length() - b.length();
           for (int x = 0; x < addNum; x++) {
               stringBuilder.append("0");
           }
           b = stringBuilder.toString() + b;
        } else if (a.length() < b.length()) {
            addNum = b.length() - a.length();
            for (int x = 0; x < addNum; x++) {
               stringBuilder.append("0");
            }
            a = stringBuilder.toString() + a;
        }
        int addFlag = 0;
        for (int y = a.length() -1; y >=0; y --) {
            int s = a.charAt(y) + (int) b.charAt(y) + addFlag - '0' - '0';
            if (s == 2) {
               addFlag = 1;
               res = "0" + res;
            } else if (s == 3) {
                addFlag = 1;
                res = "1" + res;
            } else {
                addFlag = 0;
                res = s + res;
            }
        }
        if (addFlag == 1) {
            res = "1" + res;
        }
        return  res;
    }

    public static void main(String args[]) {
        BitSum bitSum = new BitSum();
        // expect:
        // 100
        // 10101
        System.out.println(bitSum.solution(bitSum.sumA, bitSum.sumB));
        System.out.println(bitSum.solution(bitSum.sumC, bitSum.sumD));
    }

}
