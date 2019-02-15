package com.kangjian.leetcode;

import java.util.Arrays;

public class Solution977 {

    public static void main(String args[]) {
       int [] x = {-4, -1, 0, 3, 10};
       int[] res = new Solution977().sortedSquares(x);
       for (int a = 0; a < res.length; a++) {
           System.out.print(res[a] + ",");
       }
    }

    public int[] sortedSquares(int[] A) {
        for(int x = 0; x < A.length; x ++) {
           A[x] = A[x] * A[x];
        }

        Arrays.sort(A);
        return A;
    }
}
