package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/637062df51674de8ba464e792d1a0ac6?tpId=37&&tqId=21319&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */
public class HJ096 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.isEmpty()) continue;
            char t = s.charAt(s.length() - 1);
            if (t - '0' >= 0 && t - 9 <= '0') {
                s = s + "*";
            }
            StringBuilder stringBuilder = new StringBuilder();
            char          pre           = ' ';
            for (int a = 0; a < s.length(); a++) {
                if (s.charAt(a) - '0' >= 0 && s.charAt(a) - '9' <= 0) {
                    if (pre - '0' >= 0 && pre - '9' <= 0) {
                        stringBuilder.append(s.charAt(a));
                    } else {
                        stringBuilder.append("*").append(s.charAt(a));
                    }
                } else {
                    if (pre - '0' >= 0 && pre - '9' <= 0 && s.charAt(a) != '*') {
                        stringBuilder.append("*").append(s.charAt(a));
                    } else {
                        stringBuilder.append(s.charAt(a));
                    }
                }
                pre = s.charAt(a);
            }
            System.out.println(stringBuilder);
        }

    }

}
