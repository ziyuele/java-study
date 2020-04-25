/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.util;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
       int arr[] = {1,3, 5,7,9};
       int arr2[] = {4, 5, 10, 12};
       doAdd(arr, arr2);

    }

    public static void doAdd(int[] arr1, int[] arr2) {
        int ret[] = new int[arr1.length + arr2.length];
        int index = 0;
        int a = 0;
        int b = 0;
        while (index < ret.length) {
            if (a == arr1.length) {
               ret[index] = arr2[b];
               b ++;
            } else if (b == arr2.length) {
               ret[index] = arr1[a];
               a ++;
            } else {
                if (arr1[a] > arr2[b]) {
                    ret[index] = arr2[b];
                    b ++;
                } else {
                    ret[index] = arr1[a];
                    a ++;
                }
            }
            index ++;
        }
        System.out.println(Arrays.toString(ret));
    }
}
