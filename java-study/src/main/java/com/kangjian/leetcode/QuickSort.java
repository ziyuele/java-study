/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.Arrays;

public class QuickSort {
    public int arr[] = {4,3};

    public void sort(int index, int end) {
       if (index >= end)  {
           return;
       }
       int flag, i, j;
       flag = arr[index];
       i = index;
       j = end;
       while(i != j) {
           // 右边开始， 如果右边的比flag小， 就之间换到左边， 然后去左边比
          while (i< j && arr[j] >= flag) {
              // 如果大于flag， 就不管
              j --;
          }
          exchange(i, j);
          // 左边开始， 如果左边的比flag大， 就直接换到右边， 然后去右边比
          while (i<j && arr[i] <= flag) {
              // 如果小于flag 不管
              i ++;
          }
          exchange(i, j);
       }
       sort(i+1, end);
       sort(index, i-1);
    }

    public void exchange(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(0, quickSort.arr.length-1);
        for (int x = 0; x < quickSort.arr.length; x ++)  {
            System.out.print(quickSort.arr[x] + " ");
        }
        System.out.println(Arrays.asList(quickSort));
    }

}
