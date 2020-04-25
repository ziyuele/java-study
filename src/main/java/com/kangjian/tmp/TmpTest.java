/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.HashMap;
import java.util.Map;


public class TmpTest {
    public static void main(String args[]) {
        int arr[] = {1, 1, 1, 2};
        System.out.println(uniqMin(arr));
    }

    public static int uniqMin(int[] input) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int minValue = -1;
        for (int a : input) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                if (minValue == -1) {
                    minValue = entry.getKey();
                } else {
                    minValue = minValue > entry.getKey() ? entry.getKey() : minValue;
                }
            }
        }
        return minValue;
    }
}
