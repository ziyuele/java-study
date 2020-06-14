/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.Arrays;

// 冒泡排序
public class BullingSort {
    public static void main(String args[]) {
        int arr[] = {1,3,43,1,3,45,1,4,23};
        for (int a = 0; a < arr.length -1; a++) {
           for (int b = 0; b< arr.length - a -1; b++) {
               if (arr[b] < arr[b + 1]) {
                   int tmp = arr[b];
                   arr[b] = arr[b + 1];
                   arr[b + 1] = tmp;
               }
           }
           System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
