/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class TwoSum {

    public static void main(String args[]) {


    }

    public int[] twoSum(int[] numbers, int target) {
        int ret[] = new int[2];
        if (numbers.length < 2) {
            return ret;
        }
        for (int a = 0; a < numbers.length-1; a++) {
           for (int b = a+1; b < numbers.length; b++) {
              if ((numbers[a] + numbers[b])== target) {
                  ret[0] = a + 1;
                  ret[1] = b + 1;
              }
           }
        }
        return ret;
    }
}
