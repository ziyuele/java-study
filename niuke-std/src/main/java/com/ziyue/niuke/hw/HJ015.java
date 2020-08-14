package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见： https://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&&tqId=21238&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 */
public class HJ015 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String c = Integer.toBinaryString(x).replace("0", "");
        System.out.println(c.length());
    }
}
