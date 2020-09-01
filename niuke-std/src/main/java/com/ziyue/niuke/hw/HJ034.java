package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/2de4127fda5e46858aa85d254af43941?tpId=37&&tqId=21257&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *  快排参考： https://wiki.jikexueyuan.com/project/easy-learn-algorithm/fast-sort.html
 *
 */

public class HJ034 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String ret  = QuikSort.sort(line);
            System.out.println(ret);
        }
    }

    static class QuikSort {
        static StringBuilder ret = new StringBuilder();
        static char[]        charArray;

        public static String sort(String s) {
            if (ret.length() > 0) ret.delete(0, ret.length());
            charArray = s.toCharArray();
            quickSort(0, 0, charArray.length - 1);
            for (char ss : charArray) {
                ret.append(ss);
            }
            return ret.toString();
        }

        public static void quickSort(int flag, int start, int end) {
            if (start >= end) return;
            int left  = start;
            int right = end;
            while (left != right) {
                while (left < right && charArray[right] >= charArray[flag]) {
                    right--;
                }
                while (left < right && charArray[left] <= charArray[flag]) {
                    left++;
                }
                swap(right, left);
            }
            char tmp = charArray[flag];
            charArray[flag] = charArray[left];
            charArray[left] = tmp;
            quickSort(start, start,  left- 1);
            quickSort(left + 1, left + 1, end);
        }

        public static void swap(int a, int b) {
            char tmp = charArray[a];
            charArray[a] = charArray[b];
            charArray[b] = tmp;
        }
    }
}
