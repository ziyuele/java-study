/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;


// see at : https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
public class HightChecker {

    public int heightChecker1(int[] heights) {
        int ret = 0;
        int tmpArr[] = heights.clone();
        for (int a = 0; a < heights.length; a ++) {
           for (int b = a; b < heights.length; b++) {
               if (heights[a] > heights[b]) {
                   int tmp = heights[a];
                   heights[a] = heights[b];
                   heights[b] = tmp;
               }
           }
        }

        for (int x = 0; x < heights.length; x++) {
            if (heights[x] != tmpArr[x]) {
                ret ++;
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 4, 2, 1, 3};
        //int ret = new HightChecker().heightChecker(arr);
        int ret1 = new HightChecker().heightChecker1(arr);
        System.out.println(ret1);
    }
}
