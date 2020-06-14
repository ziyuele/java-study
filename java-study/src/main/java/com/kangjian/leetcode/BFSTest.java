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
public class BFSTest {
    public static void main(String args[]) {

    }

}
