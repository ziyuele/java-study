package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/434414efe5ea48e5b06ebf2b35434a9c?tpId=37&&tqId=21307&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 */

public class HJ084 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line  = scanner.nextLine();
            int    count = 0;
            for (int a = 0; a < line.length(); a++) {
                if (line.charAt(a) - 'A' >= 0 && line.charAt(a) - 'Z' <= 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
