package com.ziyue.niuke.hw;


/**
 *  原题见：
 *  https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&&tqId=21230&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

import java.util.Scanner;

public class HJ007 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        float f = scanner.nextFloat();
        int x = (int) f;
        if ((f - x) >= 0.5f) {
            System.out.println(x + 1);
        } else {
            System.out.println(x);
        }

    }
}
