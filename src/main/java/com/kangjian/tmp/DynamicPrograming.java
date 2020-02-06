/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;
import java.util.List;

public class DynamicPrograming {
    public static void main(String args[]) {
        int x = 4;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for (int a = 0; a < x; a ++) {
            list.clear();
            for (int b = 0; b <= a; b++) {
                list.add(count ++);
            }
        }
        System.out.println(list);
    }
}
