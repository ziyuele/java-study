package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见： https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&&tqId=21331&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

public class HJ108 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String numsArray[] = nums.trim().split(" ");
        int a = Integer.parseInt(numsArray[0]);
        int b = Integer.parseInt(numsArray[1]);
        int max = a > b ? a : b;
        for (int s = 1; ;s ++) {
            int ret = max *s ;
            if (ret %a == 0 && ret %b == 0) {
                System.out.println(ret);
                break;
            }
        }
    }
}
