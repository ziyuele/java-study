package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://github.com/ziyuele/study/blob/master/niuke-std/src/main/java/com/ziyue/niuke/hw/HJ107.java
 */
public class HJ107 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double  d       = scanner.nextDouble();
        System.out.print(getCubeRoot(d, 0d, d));
    }

    public static double getCubeRoot(double d, double start, double end) {
        double ret = (start + end) / 2;
        if ((ret * ret * ret) - d > 0.1d) {
            return getCubeRoot(d, 0, ret);
        } else if (d - (ret * ret * ret) > 0.1d) {
            return getCubeRoot(d, ret, end);
        }
        return Math.round(ret * 10) / 10D;
    }
}
