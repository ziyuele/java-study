/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String args[]) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        System.out.println(treeMap.put(1, 12));
        System.out.println(treeMap.put(3, 34));
        System.out.println(treeMap.put(10, 33));
        System.out.println(treeMap.put(2, 22));
        System.out.println(treeMap.floorKey(3));
        System.out.println(treeMap.ceilingKey(3));
    }
}
