package com.ziyue.niuke.hw;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 排序
 * 原题见：
 * https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3?tpId=37&&tqId=21268&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

public class HJ045 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());
            for (int a = 0; a < num; a++) {
                String s = scanner.nextLine();
                calculate(s);
            }
        }
    }

    public static void calculate(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int a = 0; a < s.length(); a ++) {
            map.put(s.charAt(a), map.getOrDefault(s.charAt(a), 0) + 1);
        }
        int a = 0;
        int start = 26;
        List<Map.Entry<Character, Integer>> entrylist =
                map.entrySet().stream().sorted((t1, t2) -> (t2.getValue() -t1.getValue())).collect(Collectors.toList());
        for (Map.Entry<Character, Integer> entry : entrylist) {
            a += entry.getValue() * start;
            start --;
        }
        System.out.println(a);
    }
}
