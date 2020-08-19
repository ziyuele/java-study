package com.ziyue.niuke.hw;

import java.util.Scanner;

/**  原题见：
 *  https://www.nowcoder.com/practice/668603dc307e4ef4bb07bcd0615ea677?tpId=37&&tqId=21297&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

public class HJ074 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        System.out.println(ss.length);
        for (String temp : ss) {
            if (temp.charAt(0) != '\"') {
                System.out.println(temp);
            } else {
                System.out.println(temp.substring(1, temp.length() - 1));
            }
        }
    }
}
