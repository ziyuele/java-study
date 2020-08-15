package com.ziyue.niuke.hw;

import java.util.Scanner;

public class HJ26 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String  s       = scanner.nextLine();
        char    sChar[] = s.toCharArray();
        char[]  ret     = QuikSort.sort(sChar);
        for (char ss : ret) {
            System.out.print(ss);
        }
    }

    static class QuikSort {

        private static char[] arr;

        public static char[] sort(char[] arrs) {
            arr = arrs;
            quickSort(0, arr.length - 1);
            return arr;
        }

        private static void exchage(int a, int b) {
            char tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        public static void quickSort(int start, int end) {
            if (start >= end) return;
            int flag  = start;
            int left  = start;
            int right = end;
            while (left != right) {
                while (left < right && arr[left] <= arr[flag]) {
                    left++;
                }
                exchage(left, flag);
                flag = left;
                while (left < right && arr[right] >= arr[flag]) {
                    right--;
                }
                exchage(right, flag);
                flag = right;
            }
            quickSort(start, flag - 1);
            quickSort(flag + 1, end);
        }
    }
}
