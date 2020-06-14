/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
    public List<Integer> solution(int[] A, int k) {
        char s[] =  (k+ "").toCharArray();
        List<Integer> list = new LinkedList<>();
        int x = 0;
        int needInput = 0;
        while (x < s.length &&  x < A.length) {
            int num = (needInput + (A[A.length - x -1] + s[s.length - x - 1] - '0')) % 10;
            needInput = (needInput + (A[A.length - x -1] + s[s.length - x- 1] - '0')) / 10;
            ((LinkedList<Integer>) list).addFirst(num);
            x ++;
        }
        while (x < s.length) {
            int num = (needInput + ( s[s.length - x- 1] - '0')) % 10;
            needInput = (needInput + ( s[s.length - x- 1] - '0') )/ 10;
            ((LinkedList<Integer>) list).addFirst( num);
            x ++;
        }
        while (x < A.length) {
            int num = (needInput + (A[A.length - x -1])) % 10;
            needInput = (needInput + (A[A.length - x -1])) / 10;
            ((LinkedList<Integer>) list).addFirst(num);
            x ++;
        }
        if (needInput != 0) {
            ((LinkedList<Integer>) list).addFirst(needInput);
        }

        return list;
    }

    public static void main(String args[]) {
        //int [] A = {9,9,9,9,9,9,9,9,9,9};
        //int k = 1;
        int [] A = {1,2,0,0};
        int k = 34;
        System.out.println(new AddToArrayForm().solution(A, k));
    }
}
