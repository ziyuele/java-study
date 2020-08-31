package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/539054b4c33b4776bc350155f7abd8f5?tpId=37&&tqId=21263&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

public class HJ040 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line  = scanner.nextLine();
            int    count = 0;
            int spaceCout = 0;
            int numCount = 0;
            int otherCount = 0;
            for (int a = 0; a < line.length(); a++) {
                char c = line.charAt(a);
                if (c - 'a' >= 0 && c - 'z' <= 0) {
                    count++;
                } else if (c - 'A' >= 0 && c - 'Z' <= 0) {
                    count++;
                } else if (c == ' ') {
                    spaceCout ++;
                } else if ( c - '0' >= 0 && c - '9' <= 0 ) {
                    numCount ++;
                } else {
                    otherCount ++;
                }
            }
            System.out.println(count);
            System.out.println(spaceCout);
            System.out.println(numCount);
            System.out.println(otherCount);
        }
    }
}
