package com.ziyue.niuke.hw;


import java.util.Scanner;

/**
 * 原题出处： https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 */
public class HJ001 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            System.out.println(line.length() - 1 - line.lastIndexOf(" "));
        }
    }
}
