package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见： https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&&tqId=21228&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *  解题思路：
 *  1.  求当前这个数的最小质因子 (根据定理： 如果一个数不是质数（合数）， 那么这个数的最小质因数一定小于等于他的平方根 )
 *  2.  将目标数字除以这个数的最小质因子， 获取新的数
 *  3.  重复上述步骤直到这个数也是质数为止
 *
 *  4.  需要注意处理别界场景
 */
public class HJ006 {

    public static void main(String args[]){
        solution(new Scanner(System.in).nextLong());
    }

    public static void solution(long value) {
        long num = new Double(Math.sqrt(value)).longValue();
        for (long a = 2; a <= num; a++ ) {
            if (value % a == 0) {
                System.out.print(a + " ");
                if (value != a) solution(value / a);
                return;
            }
        }
        // 输入的数就是质数的场景
        if (num <= value) {
            System.out.print(value + " ");
        }
    }
}
