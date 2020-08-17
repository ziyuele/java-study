package com.ziyue.niuke.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ056 {


    public static void main(String[] args) throws IOException {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
        String         str = null;
        while ((str = bfd.readLine()) != null) {
            int n = Integer.parseInt(str);
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (isPerfect(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int     num     = scanner.nextInt();
        int     ret     = num;
        int     count   = 0;
        while (num > 2) {
            int tmp = 0;
            for (int a = 1; a < num / 2; a ++) {
                if (num % 2 == 0) {
                    tmp += num /2;
                }
            }
        }
        //System.out.println(count);
    }

}
