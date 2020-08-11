package com.ziyue.niuke.hw;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * 原题出处： https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&&tqId=21226&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 思路： 1. 使用set 容器， 时间复杂度 On(logn) + O（n + m）空间复杂度: o(n)
 * 思路： 2. 先排序【可以使用快排】 O(logn) + O(n) 空间复杂度 o(logn)
 */
public class HJ003 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            Set set = new TreeSet<Integer>();
            while (num > 0) {
                set.add(scanner.nextInt());
                num--;
            }
            set.forEach(System.out::println);
        }
    }
}
