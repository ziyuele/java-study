package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&&tqId=21237&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 解体思路:
 * 1. 使用快排
 * 1. 快排流程
 * a. 选取最左， 最有，和标记值(这里选取最左第一个作为标记值)
 * b. 从左到右比， 发现有比他大的值， 那么和标志位交换位置
 * c. 交换位置后， 从右到左比， 选取比他小的值， 如此重复
 * 递归调用
 * 2. 排序因子为从左到右比较他们的Ascii值
 *
 *
 *
 * 注意注意注意：
 * 一定要考虑边界问题， 一定要考虑边界问题
 */

public class HJ014 {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        int      lineNum = Integer.parseInt(scanner.nextLine().trim());
        String[] arr     = new String[lineNum];
        for (int a = 0; a < lineNum; a++) {
            arr[a] = scanner.nextLine();
        }
        String[] res = QuickSort.sort(arr);
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static boolean isLarger(String a, String b) {
        int x = 0;
        while (a.length() > x && b.length() > x) {
            int ret = a.charAt(x) - b.charAt(x);
            if (ret != 0) {
                return ret > 0;
            }
            x++;
        }
        return a.length() >= b.length();
    }

    static class QuickSort {
        private static String[] ret;

        public static String[] sort(String[] arr) {
            ret = arr;
            quickSort(0, ret.length - 1);
            return ret;
        }

        private static void exchange(int a, int b) {
            String tmp = ret[a];
            ret[a] = ret[b];
            ret[b] = tmp;
        }

        private static void quickSort(int start, int end) {
            if (start >= end) return;
            int left  = start;
            int right = end;
            int flag  = start;
            while (left != right) {
                while (left < right && !isLarger(ret[left], ret[flag])) {
                    left++;
                }
                exchange(left, flag);
                flag = left;

                while (left < right && isLarger(ret[right], ret[flag])) {
                    right--;
                }
                exchange(right, flag);
                flag = right;
            }
            quickSort(start, flag - 1);
            quickSort(flag + 1, end);
        }
    }
}
