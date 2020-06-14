/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

public class BItNums {
    public static void main (String args[]) {
        int arr[] = {1, 0, 0};
        int arr1[] = {1,1,1,0};
        BItNums bItNums = new BItNums();
        bItNums.soloation(arr);
        bItNums.soloation(arr1);
    }

    // 0 1 bit
    public boolean soloation(int arr[]) {
        int x = 0;
        while( x <  arr.length - 1) {
            if (arr[x] == 0)  {
               x = x+1;
            } else {
                x += 2;
            }
        }
        return arr.length - x == 1;
    }
}
