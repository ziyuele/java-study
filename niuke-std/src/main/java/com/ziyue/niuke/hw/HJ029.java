package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/2aa32b378a024755a3f251e75cbf233a?tpId=37&&tqId=21252&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 */

public class HJ029 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (scanner.hasNextLine()) {
            String        line          = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            if (b) {
                for (int a = 0; a < line.length(); a++) {
                    // 数字
                    char s   = 'a' - 'A';
                    if (line.charAt(a) - '9' <= 0) {
                        if (line.charAt(a) - '9' == 0) {
                            stringBuilder.append('0');
                            continue;
                        }
                        char ret = (char) (line.charAt(a) + 1);
                        stringBuilder.append(ret);
                    }
                    // 大写字母
                    else if (line.charAt(a) - 'Z' <= 0) {
                        char ret = (char) (line.charAt(a) + s + 1);
                        if (ret - 'z' > 0) {
                            stringBuilder.append('a');
                            continue;
                        }
                        stringBuilder.append(ret);
                    } else {
                        char ret = (char) (line.charAt(a) - s + 1);
                        if (ret - 'Z' > 0) {
                            stringBuilder.append("A");
                            continue;
                        }
                        stringBuilder.append(ret);
                    }
                }
                System.out.println(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length() -1);
                b = false;
            } else {
                for (int a = 0; a < line.length(); a++) {
                // 数字
                char s   = 'a' - 'A';
                if (line.charAt(a) - '9' <= 0) {
                    if (line.charAt(a) - '0' == 0) {
                        stringBuilder.append('9');
                        continue;
                    }
                    char ret = (char) (line.charAt(a) - 1);
                    stringBuilder.append(ret);
                }
                // 大写字母
                else if (line.charAt(a) - 'Z' <= 0) {
                    char ret = (char) (line.charAt(a) + s - 1);
                    if (ret - 'a' < 0) {
                        stringBuilder.append('z');
                        continue;
                    }
                    stringBuilder.append(ret);
                } else {
                    char ret = (char) (line.charAt(a) - s - 1);
                    if (ret - 'A' < 0) {
                        stringBuilder.append('Z');
                        continue;
                    }
                    stringBuilder.append(ret);
                }
            }
            System.out.println(stringBuilder);
            stringBuilder.delete(0, stringBuilder.length() -1);
            b = true;
            }
        }

    }
}
