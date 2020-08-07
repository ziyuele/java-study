package com.kangjian.leetcode;

public class PrimeNumber {

    public static void getPrimeNumber1(int maxValue) {
        for (int a = 1; a <= maxValue; a ++) {
            boolean isPrimeNumber = true;
            for (int b = 2; b < maxValue; b ++ ) {
                if (b >= a) {
                   continue;
                }
                if (a % b == 0) {
                    isPrimeNumber = false;
                }
            }
            if (isPrimeNumber) {
               System.out.print(a + " ");
            }
        }
        System.out.println();
    }

    public static void getPrimeNumber2(int maxValue) {
        for (int a = 1; a <= maxValue; a ++) {
            boolean isPrimeNumber = true;
            for (int b = 2; b <= Math.sqrt(maxValue); b ++ ) {
                if (b >= a) {
                    continue;
                }
                if (a % b == 0) {
                    isPrimeNumber = false;
                }
            }
            if (isPrimeNumber) {
                System.out.print(a + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        getPrimeNumber1(15);
        getPrimeNumber2(15);
    }
}
