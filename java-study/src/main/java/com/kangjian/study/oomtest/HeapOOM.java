/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.study.oomtest;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    public static void main(String args[]) {

        List list = new ArrayList<>();
        while (true) {
            int arr[] = new int[10240];
            list.add(arr);
        }
    }
}
