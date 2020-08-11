package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题处处： https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&&tqId=21227&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 时间复杂度： O(n) ， 空间复杂度 O（1）
 */
public class HJ004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int     num     = 2;
        while (num > 0) {
            String s    = scanner.nextLine();
            int    base = 0;
            while (base < s.length()) {
                for (int a = 0; a < 8; a++) {
                    if (base >= s.length()) {
                        System.out.print("0");
                    } else {
                        System.out.print(s.charAt(base));
                    }
                    base++;
                }
                System.out.println();
            }
            num --;
        }
    }
}
