/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempTests {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(8);
        list2.add(9);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        getNum(lists);
    }

    public static int getNum(List<List<Integer>> list) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int mdeumIndex = 0;
        for (int b = 0; b < list.size(); b++) {
            mdeumIndex += list.get(b).size();
        }
        int count = 0;
        int ret = 0;
        int tmp = Integer.MAX_VALUE;
        int tmpIndex = Integer.MAX_VALUE;
        System.out.println(mdeumIndex + "======");
        while ( count < mdeumIndex / 2) {
            for (int a = 0; a < list.size(); a++) {
                int index = indexMap.getOrDefault(a, 0);
                int value = list.get(a).get(index);
                System.out.println(value);
                if (value < tmp) {
                    tmp = value;
                    tmpIndex = a;
                }
            }
            indexMap.put(tmpIndex, indexMap.getOrDefault(tmpIndex, 0)+ 1);
            ret = tmp;
            tmp = Integer.MAX_VALUE;
            count ++;
        }
        return ret;
    }

}
