/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

// set at: https://leetcode-cn.com/problems/count-and-say/
public class CountAndSay {

    public String countandSay(int x) {

        if (x == 1) {
            return "1";
        }
        int count = 1;
        String s = "1";
        while ( count < x ) {
            s = getNext(s);
            count++;
        }
        return s;

    }

    public String getNext(String s) {
        String ret = "";
        char[] chars = s.toCharArray();
        char tmp = chars[0];
        int cout = 1;
        for (int a = 0; a < chars.length; a++) {
            if (tmp == chars[a]) {
                cout++;
            } else {
               ret += cout + "" + tmp;
               tmp = chars[a];
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        System.out.println(new CountAndSay().countandSay(1));
        System.out.println(new CountAndSay().countandSay(2));
        System.out.println(new CountAndSay().countandSay(3));
        System.out.println(new CountAndSay().countandSay(4));
        System.out.println(new CountAndSay().countandSay(5));
    }
}
