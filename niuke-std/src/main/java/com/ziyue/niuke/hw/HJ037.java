package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/1221ec77125d4370833fd3ad5ba72395?tpId=37&&tqId=21260&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 * 思路： 三个月为步长
 *  分别计算每个月 年龄一个月的兔子
 *              年龄两个月的兔子
 *              年龄大于等于三个月的兔子
 *  最后将结果求和， 就是所有的兔子数
 *  整体思路和斐波那契数列相似， 但是粒度放长
 */
public class HJ037 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            // 一个月的兔子， 两个月的兔子， 三个月的兔子
            int a = 1, b = 0, c = 0;
            while (num > 1) {
                c = c + b;
                b = a;
                a = c ;
                num --;
            }
            System.out.println(a + b + c);
        }

    }
}
