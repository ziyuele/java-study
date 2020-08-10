package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见： https://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&&tqId=21232&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *  解题思路：
 *  1. 不重复的数字最多有10个 0，1，2，3，4，5，6，7，8，9
 *  2. 数字对应的ascii 码表中 0 的码值是48
 *  3. 对char 类型的数字减48 就是真实的数字值
 *  4. 创建一个长度为10 的数组保存已经输出的数字， 没有输出的默认为0, 挨个检查输出就可以
 *
 *  时间复杂度： O(n), 空间复杂度 O(10)
 */
public class HJ9 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int[] arr = new int[10];
            for (int x = s.length() -1; x >= 0; x--) {
               char c = s.charAt(x);
               if (arr[c - 48] == 0) {
                    System.out.print(s.charAt(x));
                    arr[c - 48] = 1;
               }
            }
            System.out.println();
        }
    }
}
