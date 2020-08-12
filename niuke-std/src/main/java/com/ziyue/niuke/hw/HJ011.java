package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见： https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe?tpId=37&&tqId=21234&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 什么玩意儿～
 */

public class HJ011 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(int a = s.length() -1 ; a >= 0; a--) {
           System.out.print(s.charAt(a));
        }
    }

}
