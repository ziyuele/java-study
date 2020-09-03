package com.ziyue.niuke.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 原题见:
 * https://www.nowcoder.com/practice/3350d379a5d44054b219de7af6708894?tpId=37&&tqId=21317&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

public class HJ094 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int                  pNum    = Integer.parseInt(scanner.nextLine());
            String[]             pName   = scanner.nextLine().trim().split(" ");
            Integer              tNum    = Integer.parseInt(scanner.nextLine());
            String[]             ticket  = scanner.nextLine().trim().split(" ");
            int                  Invalid = 0;
            Map<String, Integer> tMap    = new HashMap<>();
            for (String name : pName) {
                tMap.put(name, 0);
            }
            for (String t : ticket) {
                if (!t.isEmpty()) {
                    if (tMap.containsKey(t)) {
                        tMap.put(t, tMap.get(t) + 1);
                    } else {
                        Invalid++;
                    }
                }
            }
            for (String name : pName) {
                System.out.println(name + " : " + tMap.get(name));
            }
            System.out.println("Invalid : " + Invalid);
        }
    }
}
