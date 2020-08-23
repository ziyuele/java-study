package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&&tqId=21243&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *  时间复杂度 0(n)
 */

public class HJ020 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.length() <= 8) {
                System.out.println("NG");
            } else {
                String tmp        = "";
                int  intCount   = 0;
                int  lowerCount = 0;
                int  upperCount = 0;
                int  otherCount = 0;
                for (int a = 0; a < s.length(); a++) {
                    tmp = s;
                    if (a + 3 <= s.length() && tmp.replace(s.substring(a, a + 3), "").length() < (s.length() - 3)) {
                        intCount = -10;
                        break;
                    }
                    if (s.charAt(a) <= '9' && s.charAt(a) >= '0') {
                        intCount = 1;
                    } else if (s.charAt(a) <= 'Z' && s.charAt(a) >= 'A') {
                        upperCount = 1;
                    } else if (s.charAt(a) <= 'z' && s.charAt(a) >= 'a') {
                        lowerCount = 1;
                    } else {
                        otherCount = 1;
                    }
                }
                if ((intCount + upperCount + lowerCount + otherCount) < 3) {
                    System.out.println("NG");
                } else {
                    System.out.println("OK");
                }

            }
        }
    }
}
