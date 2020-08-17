package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/f792cb014ed0474fb8f53389e7d9c07f?tpId=37&&tqId=21323&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */
public class HJ100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int num     = Integer.parseInt(scanner.nextLine());
            int pre     = 2;
            int current = 2;
            int ret = 2;
            if (1 == num) {
                continue;
            }
            for (int a = 0; a < num - 1; a++) {
                pre = current;
                current = pre + 3;
                ret += current;
            }
            System.out.println(ret);
        }
    }
}
