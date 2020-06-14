/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class AddDigits {
    public int solution(int num) {
        int ret  = num;
        while (ret >=10) {
            ret = int2List(ret);
        }
        return ret;
    }

    public int int2List(int num) {
          int tmp = num;
          int ret = 0;
          while ( tmp / 10 !=0) {
             ret += tmp % 10;
             tmp = tmp / 10;
          }
          return ret + tmp;
    }

    public static void main(String args[]) {
        System.out.println(new AddDigits().solution(38));
   }
}
