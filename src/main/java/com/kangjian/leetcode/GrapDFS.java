/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class GrapDFS {
    private static final int graph[][] =  {
            {1, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 1, 1, 0}
    };
    public static void dfs(int startX, int startY) {
        if (graph[startX][startY] != 1) {
            return;
        }
        // 标记vesited
        graph[startX][startY] = -1;
        System.out.println(startX + ":" + startY);
        //left
        if (startX - 1 >= 0) {
            dfs(startX-1, startY);
        }
        if (startX +1 < graph.length) {
            dfs(startX + 1, startY);

        }
        if (startY - 1 >= 0) {
            dfs(startX, startY - 1);
        }
        if (startY + 1 < graph[startX].length) {
            dfs(startX, startY + 1);
        }
    }

    public static void main(String args[]) {
       dfs(0, 0);
    }
}
