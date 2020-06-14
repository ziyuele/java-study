/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class QuickSortOne {
    public int arr[] = {1,3,43,1,3,45,1,4,23};


    public void sort(int start, int end) {
        // 选取一个基准值
        int flag = arr[start];
        int flagIndex = start;

        while (start < end) {
           if (arr[start] > flag) {
               exchange(start, flagIndex);
               flagIndex = start;
           }
        }
    }

    public void exchange(int from, int to) {
       int tmp = arr[from];
       arr[from] = arr[to];
       arr[to] = tmp;
    }
}
