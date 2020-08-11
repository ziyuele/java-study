package com.ziyue.niuke.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  原题见: https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&&tqId=21231&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *  解题思路： 有序hash
 *  hash类型： HashMap (随机)， LinkedHashMap(固定顺序), TreeMap(有序)
 *           选用TreeMap
 */

public class HJ008 {
    public static void main(String args[]) {
        Scanner               scanner = new Scanner(System.in);
        int                   linNum  = Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> map     = new HashMap<>();
        for (int a = 0; a < linNum; a++) {
            String s     = scanner.nextLine();
            int    key   = Integer.parseInt(s.split(" ")[0].trim());
            int    value = Integer.parseInt(s.split(" ")[1].trim());
            int    num   = map.getOrDefault(key, 0);
            map.put(key, num + value);
        }
    }
}
