package com.ziyue.niuke.hw;

import java.util.Scanner;


/**
 * 原题见： https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&&tqId=21228&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 解题思路: 1. 这个题考Ascii 码表， 0码值 48； A的码值是65, 按照这个去推
 *         2. 推导的过程中需要注意进位的问题
 *
 *         时间复杂度 O(n), 空间复杂度 O(n)
 */
public class HJ005 {

    public static void main(String args[]) {
        int ret = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                continue;
            }
            s = s.toUpperCase();
            for (int a = s.length() -1 ; a > 1; a--) {
                int tmp = 0;
                if(s.charAt(a) - 'A' >= 0) {
                    tmp = (s.charAt(a) - 'A' + 10);
                } else {
                    tmp = (s.charAt(a) - '0');
                }
                ret += a == s.length() -1 ? tmp : tmp * Math.pow(16, s.length() - a -1);
            }
            System.out.println(ret);
            ret = 0;
        }
    }
}
