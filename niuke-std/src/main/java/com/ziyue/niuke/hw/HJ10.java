package com.ziyue.niuke.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 原题见： https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&&tqId=21233&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *  解题思路： hash 去重
 */
public class HJ10{

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character, Character> characterMap = new HashMap<>();
        for (int a = 0; a < s.length(); a++) {
            characterMap.put(s.charAt(a), s.charAt(a));
        }
        System.out.println(characterMap.size());
    }

}
