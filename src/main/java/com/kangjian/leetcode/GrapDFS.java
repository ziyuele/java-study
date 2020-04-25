/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

//用户的页面浏览跳转的历史记录，比如：a-->b，表示用户从前一页面a跳下一页面b，现在希望统计从任意页面之间跳转的最短路径；
//比如跳转记录如下(如果是起始访问的页面，前一页面用NULL表示)：
//F    A
//NULL A
//A    B
//B    D
//B    F
//A    E
//E    F
//D    E
//B    D
//B    C
//G    B
//F    G
//上述用户的行为路径中，页面A到页面F有以下两种方式
//1 A->B->D->E->F
//2 A->E->F
//此时方式2跳转次数最少，为2

public class GrapDFS {
    private static final int graph[][] =  {
            //A  B  C  D  E  F   G
             {1, 0, 0, 0, 0, 0, 0}, // A
             {1, 0, 0, 0, 0, 0, 1}, // B
             {0, 1, 0, 0, 0, 0, 0}, // C
             {0, 1, 0, 0, 0, 0, 0}, // D
             {1, 0, 0, 1, 0, 0, 0}, // E
             {0, 1, 0, 0, 1, 0, 0}, // F
             {0, 0, 0, 0, 0, 1, 0}, // G
    };
    static int res = Integer.MAX_VALUE;
    static int destX = 6;

    public static void dfs(int x,  int count) {
        for (int a = 0 ; a < graph.length; a++) {
            System.out.println(x + "," + a + ":" + graph[x][a]);
            if (graph[a][x] == 1 && x != a) {
                if (a == destX) {
                    System.out.println("dadsa");
                    res = res > count + 1? count + 1: res;
                }  else {
                    System.out.println("diigui le ");
                    graph[a][x] = -1;
                    dfs(a, count ++);
                }
            }
        }
    }

    public static void main(String args[]) {
       dfs( 0, 0);
       System.out.println(res);
    }
}
