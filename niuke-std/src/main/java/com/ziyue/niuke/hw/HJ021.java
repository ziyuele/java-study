package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 *  原题见：
 *  https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&&tqId=21244&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *  时间复杂度 o(n)，
 */

public class HJ021 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int a = 0; a< s.length(); a ++) {
                // 大写字母
                if (s.charAt(a) - 'a' < 0 && s.charAt(a) > 64) {
                        char ret = (char)(s.charAt(a) + 33);
                        if (ret > 122) {
                            ret = 'a';
                        }
                        stringBuilder.append(ret);
                }
                // 小写字母
                else if (s.charAt(a) - 'a' >= 0) {
                      switch (s.charAt(a)) {
                          case 'a':
                          case 'b':
                          case 'c':
                              stringBuilder.append('2');
                              continue;
                          case 'd':
                          case 'e':
                          case 'f':
                              stringBuilder.append('3');
                              continue;
                          case 'g':
                          case 'h':
                          case 'i':
                              stringBuilder.append('4');
                              continue;
                          case 'j':
                          case 'k':
                          case 'l':
                              stringBuilder.append('5');
                              continue;
                          case 'm':
                          case 'n':
                          case 'o':
                              stringBuilder.append('6');
                              continue;
                          case 'p':
                          case 'q':
                          case 'r':
                          case 's':
                              stringBuilder.append('7');
                              continue;
                          case 't':
                          case 'u':
                          case 'v':
                              stringBuilder.append('8');
                              continue;
                          default:
                              stringBuilder.append('9');
                              continue;
                      }
                }
                // 数字
                else {
                    stringBuilder.append(s.charAt(a));
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
