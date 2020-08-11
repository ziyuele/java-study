package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题出处: https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&&tqId=21225&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 思路： 遍历累加， 时间复杂度 O(n), 空间复杂度0(1)
 */
public class HJ002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  sting;
        char    s;
        int     count   = 0;
        while (scanner.hasNextLine()) {
            sting = scanner.nextLine().toLowerCase();
            s     = scanner.nextLine().toLowerCase().trim().toCharArray()[0];
            for (int a = 0; a < sting.length(); a++) {
                if (sting.charAt(a) == s) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        }
    }
}
