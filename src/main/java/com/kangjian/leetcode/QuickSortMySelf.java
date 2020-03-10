/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.Arrays;

public class QuickSortMySelf {

    static int arr[] = {5, 3, 43, 100, 3, 45, 69, 4, 23};

    public static void main(String[] args) {
        sort(0, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));
    }

    public static void sort(int flag, int lIndex, int Rindex) {
        int left = lIndex;
        int right = Rindex;
        int f = flag;
        while ( lIndex < Rindex -1) {
            while ( arr[f] < arr[Rindex]) {
                Rindex --;
            }
            int x = arr[f];
            arr[f] = arr[Rindex];
            arr[Rindex] = x;
            f = Rindex;
            while (arr[f] > arr[lIndex]) {
               lIndex ++;
            }
            int y = arr[f];
            arr[f] = arr[lIndex];
            arr[lIndex] = y;
            f = lIndex;
        }
        System.out.println(Arrays.toString(arr));
        if (f > left) {
            sort(left, left, f -1);
        }
        if (f < right) {
            sort(f + 1, f+1, right);
        }
    }

}
