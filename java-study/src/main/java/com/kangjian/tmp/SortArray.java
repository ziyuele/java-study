/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class SortArray {
    // 思路，两端两个指针, 每次获取一个最大的添加到数组中
    public static void main(String [] args) {
        int[] arr = {-9, -8, -5, 0, 1, 6, 11, 199, 100};
        int res[] = new int[arr.length];
        int flag = res.length - 1;

        int left = 0; int right = arr.length -1;
        while (left <= right && flag >= 0) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                res[flag] = arr[left];
                left ++;
            } else {
                res[flag] = arr[right];
                right --;
            }
            flag --;
        }

        for (int x = 0; x < res.length; x ++) {
            System.out.println(res[x]);
        }
    }
}
