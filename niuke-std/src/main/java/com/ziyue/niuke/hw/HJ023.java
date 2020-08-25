package com.ziyue.niuke.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 原题见：
 * https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&&tqId=21246&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 *  时间复杂度 O(n) + O(n-m)
 *
 */

public class HJ023 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Map<String, Integer> map = new HashMap<>();
            for (int a = 0; a< line.length(); a ++) {
                map.put(line.charAt(a) + "", map.getOrDefault(line.charAt(a)+"", 0) + 1);
            }
            boolean b = false;
            int num = 1;
            while (!b) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    String  k = entry.getKey();
                    Integer v = entry.getValue();
                    if (v == num) {
                        line = line.replace(k, "");
                        b = true;
                        continue;
                    }
                }
                num ++;
            }
            System.out.println(line);
        }
    }
}
