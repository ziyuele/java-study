package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/81544a4989df4109b33c2d65037c5836?tpId=37&&tqId=21254&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 * 时间复杂度 o(2N)
 */

public class HJ031 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            for (int b = 0; b < s.length(); b++) {
                char c = s.charAt(b);
                if (c == ' ') continue;
                if (c < 'A') s =  s.replace(c+"", " "); ;
                if (c > 'Z' && c < 'a') s =  s.replace(c+"", " ");
                if (c > 'z') s = s.replace(c+"", " ");
            }
            s = s.trim();
            String words[] = s.split(" ");
            for (int a = words.length -1; a >=0; a--) {
                String w = words[a];
                if ("".equals(words[a])) {
                    continue;
                }
                if (a >0) {
                    w += " ";
                }
                System.out.print(w);
            }
            System.out.println();
        }
    }
}
