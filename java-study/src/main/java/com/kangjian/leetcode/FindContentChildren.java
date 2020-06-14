/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {

    public int solution(int [] g, int [] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int x = 0; x<g.length; x++) {
            for (int y = 0; y < s.length; y++) {
               if (s[y]== g[x]) {
                   s[y] = -1;
                   count++;
                   break;
               }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        //孩子
        int g [] = {10 ,9,8, 7};
        // 饼干
        int s [] = {5, 6,7, 8};
        int ret = new FindContentChildren().solution(g, s);
        System.out.println(ret);
    }
}
