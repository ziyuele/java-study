package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见： https://www.nowcoder.com/practice/6abde6ffcc354ea1a8333836bd6876b8?tpId=37&&tqId=21320&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *
 */

public class HJ097 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int negativeNum = 0;
            int positiveNum = 0;
            int positiveSum = 0;
            int zeroNum = 0;
            for (int a = 0; a < num; a++ ) {
                int x = scanner.nextInt();
                if (x >= 0) {
                    positiveNum ++;
                    if (x == 0) {
                        zeroNum ++;
                    }
                    positiveSum += x;

                } else {
                    negativeNum ++;
                }
            }
            double  average = (double) positiveSum / (double) (positiveNum - zeroNum);
            double ret = Math.round(average * 10) / 10D;
            System.out.println(negativeNum + " " + ret);
        }
    }
}
