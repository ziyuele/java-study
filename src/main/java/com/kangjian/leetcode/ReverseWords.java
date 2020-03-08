/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

// set at :https://leetcode-cn.com/problems/reverse-words-in-a-string/
public class ReverseWords {

    public static void main(String args[]) {
        String s1 = "  hello world!  ";
        String s2 = "the sky is blue";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    public static String solution(String s) {
        String arr[] = s.split(" ");
        String ret = "";
        for (int a = arr.length -1; a >=0; a--) {
            System.out.println(a + "|" + arr[a] + "|");
            if (arr[a].equals("")) {
                continue;
            }
            if (ret.equals("")) {
                ret +=  arr[a];
                continue;
            }
            ret += " " + arr[a];
        }
        return ret;
    }
}
