/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class ArrayPartition {
    private int arr[];
    public int solution(int nums[]) {
        this.arr = nums;
        int ret = 0;
        if (arr.length == 1) {
            return arr[0];
        }
        quickSort(0, arr.length -1);
        for (int x = 0; x < arr.length; x+=2) {
            ret +=  arr[x];
        }
        return ret;
    }
    private void quickSort(int start, int end) {
       if (start >= end) {
           return;
       }
       int flag, i, j;
       flag = arr[start];
       i = start;
       j = end;
       while(i != j) {
           while(i < j && arr[j] >= flag) {
              j--;
           }
           exchange(i, j);
           while (i < j && arr[i] <= flag) {
               i ++;
           }
           exchange(i, j);
       }
       quickSort(i +1, end);
       quickSort(start, i-1);
    }
    public void exchange(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String args[]) {
        int num[] = {1,4,3,2};
        int ret = new ArrayPartition().solution(num);
        System.out.println(ret);
    }
}