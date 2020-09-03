package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见： https://www.nowcoder.com/practice/2f6f9339d151410583459847ecc98446?tpId=37&tqId=21260&rp=1&ru=%2Fta%2Fhuawei%2F&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 *
 */
public class HJ038 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            double length = num;
            int x = 0;
            double ret = num;
            while (x < 5) {
               ret  /= 2d;
               if (x != 4) {
                   length += ret * 2;
               }
               x ++;
            }
            System.out.println(Math.round(length * 1000000D) / 1000000D);
            System.out.println(Math.round(ret * 1000000D)/ 1000000D);
        }
    }
}
