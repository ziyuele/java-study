package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/a30bbc1a0aca4c27b86dd88868de4a4a?tpId=37&&tqId=21269&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *
 */
public class HJ046 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int num = Integer.parseInt(s.split(" ")[1].trim());
            s = s.split(" ")[0];
            char schar[] = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            for (char c : schar) {
                if ((int) c > 127 && num - count > 1) {
                    stringBuilder.append(c);
                    count += 2;
                } else if (c < 128 && num - count >= 1 ){
                   stringBuilder.append(c);
                   count += 1;
                }  else {
                    break;
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
