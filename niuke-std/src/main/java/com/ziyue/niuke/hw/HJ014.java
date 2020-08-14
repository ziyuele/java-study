package com.ziyue.niuke.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *
 * 有点意思
 *
 */

public class HJ014 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int lineNum = Integer.parseInt(scanner.nextLine().trim());
        String arr[] = new String[lineNum];
        for (int a = 0; a < lineNum; a++) {
            arr[a] = scanner.nextLine();
        }
       String res[]  = QuickSort.sort(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int isLarger(String a, String b) {
        System.out.print(a + " ====  " + b);
        int x = 0;
        while (a.length() > x && b.length() > x) {
            int ret = a.charAt(x) - b.charAt(x);
            if (ret != 0) {
                System.out.println(" ret is : " + ret);
                return ret;
            }
            x ++;
        }
        System.out.println(" ret is : 0") ;
        return 0;
    }

    static class QuickSort {
       private static String[] ret;

       public static String[] sort(String arr[]) {
           System.out.println("start my job");
           ret = arr;
           System.out.println(Arrays.asList(ret));
           quickSort(0, ret.length -1);
           return ret;
       }
       private static void exchange(int a, int b) {
            String tmp = ret[a];
            ret[a] = ret[b];
            ret[b] = tmp;
            System.out.println("+++++++++" + Arrays.asList(ret));
       }

       private static void quickSort(int start, int end) {
           System.out.println("start my job wwww");
           if (start >= end) return;
           String flag = ret[start];
           int i  = start, j = end;
           while (i != j) {
               while (i < j && isLarger(ret[i], flag) >= 0) {
                   i ++;
               }
               exchange(j, i);
               while (i < j && isLarger(ret[j], flag) <= 0 ) {
                   j --;
               }
               exchange(i, j);
           }
           quickSort(start, i-1);
           quickSort(i + 1, end);
       }
    }
}
