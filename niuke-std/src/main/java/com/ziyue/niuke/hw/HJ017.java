package com.ziyue.niuke.hw;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&&tqId=21240&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *  时间复杂度 O(N)
 */

import java.util.Scanner;

public class HJ017 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int a = 0;
            int b = 0;
            String line = scanner.nextLine();
            String items[] = line.replace(" ", "").split(";");
            for (String s: items) {
                if (null== s || s.length() < 2) continue;
                char way = s.charAt(0);
                try {
                    String numString = s.substring(1, s.length());
                    int num = Integer.parseInt(numString);
                    if (num > 100) {
                        continue;
                    }
                    switch (way) {
                        case 'A':
                            a -=num;
                            continue;
                        case 'S':
                            b -=num;
                            continue;
                        case 'W':
                            b += num;
                            continue;
                        case 'D':
                            a += num;
                            continue;
                        default:
                            continue;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println(a + "," + b);
        }
    }
}
