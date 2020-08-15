package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/4b1658fd8ffb4217bc3b7e85a38cfaf2?tpId=37&&tqId=21309&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 偷个懒～
 */
public class HJ86 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int      b   = scanner.nextInt();
            String[] s   = Integer.toBinaryString(b).split("0");
            int      max = 0;
            for (String si : s) {
                max = si.length() > max ? si.length() : max;
            }
            System.out.println(max);
        }
    }
}

