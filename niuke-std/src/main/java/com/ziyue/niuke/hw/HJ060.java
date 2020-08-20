package com.ziyue.niuke.hw;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ060 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer>  list = new ArrayList<>();
        int minVale = Integer.MAX_VALUE;
        int aa = 0;
        int bb = 0;
        for (int x = 3; x < num; x ++) {
            if (isSuShu(x)) list.add(x);
        }
        for (int a = 0; a < list.size(); a ++) {
            for (int b = a + 1; b < list.size(); b ++) {
                if (list.get(a) + list.get(b) == num) {
                    if (list.get(b) - list.get(a) < minVale) {
                        aa = list.get(a);
                        bb = list.get(b);
                        minVale = list.get(b) - list.get(a);
                    }
                }
            }
        }
        System.out.println(aa);
        System.out.println(bb);
    }
    private static boolean isSuShu(int num) {
        for (int a = 2; a < Math.sqrt(num); a ++) {
            if (num % a == 0) {
                return false;
            }
        }
        return true;
    }
}
