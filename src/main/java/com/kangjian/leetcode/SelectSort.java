/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.Arrays;

// 选择排序
public class SelectSort {
    public static void main(String args[]) {
        int arr[] = {1, 3, 43, 1, 3, 45, 1, 4, 23};

        for (int a = 0; a < arr.length; a++) {
            for (int b = a; b < arr.length; b++) {
                if (arr[a] > arr[b]) {
                    int tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
