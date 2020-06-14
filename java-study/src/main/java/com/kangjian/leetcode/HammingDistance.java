/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int count = 0;
        int a = x > y ? y : x;
        int b = x > y ? x : y;
        while ( a < b ) {
            a = a << 1;
            count++;
        }
        return a > b ? count -1 : count;
    }

    public static void main(String args[]) {
        int ret = new HammingDistance().hammingDistance(2, 8);
        System.out.println(ret);
    }
}
