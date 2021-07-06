package com.ziyue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    @Test
    public void doTest() {
        String s = "aaaaa";
        System.out.println(solutionB(s));
    }

    public String solutionA(String s) {
        String maxRet = s.substring(0, 1);
        for (int a = 0; a < s.length() -1 ; a ++) {
            String ret1 = getMaxPalindrome(s, a, a);
            String ret2 = getMaxPalindrome(s, a, a+1);
            String ret = ret1.length() > ret2.length() ? ret1 : ret2;
            maxRet = ret.length() > maxRet.length() ? ret : maxRet;
        }
        return maxRet;
    }

    public String getMaxPalindrome(String s, int lIndx, int rIndex) {
        if (s.charAt(lIndx) != s.charAt(rIndex)) {
            return s.charAt(lIndx) + "";
        }
        while (lIndx >= 0 && rIndex < s.length() && s.charAt(lIndx) == s.charAt(rIndex)) {
            lIndx --;
            rIndex ++ ;
        }
        return s.substring(lIndx + 1, rIndex);   // 索引， 包含头， 不包含尾啊
    }

    public String solutionB(String s) {
        // 以s为开头 m 为结尾的的字符串，是否是回文串
       boolean dp[][] = new boolean[s.length()][s.length()];
       // 长度为1的都是true
       for (int a = 0; a < s.length(); a ++) {
           dp[a][a] = true;
       }
       String Maxret = s.charAt(0) + "";
       for (int a = 0; a < s.length() -1; a ++) { // 这个为什么只能写成长度
           for (int b = a + 1; b < s.length(); b ++) {
                if (s.charAt(a) != s.charAt(b)) {
                    dp[a][b] = false;
                } else {
                    if (b - a < 3) {
                        dp[a][b] = true;
                    } else {
                        dp[a][b] = dp[a + 1][b - 1];
                    }
                }
               if (dp[a][b] && s.substring(a, b +1).length() > Maxret.length())  {
                   Maxret = s.substring(a, b + 1);
               }
           }
       }
       return Maxret;
    }
}
