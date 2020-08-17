package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37&&tqId=21329&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */
public class HJ106 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int a = s.length() -1 ; a >= 0;  a--) {
            System.out.print(s.charAt(a));
        }
    }
}
