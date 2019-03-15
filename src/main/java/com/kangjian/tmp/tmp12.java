/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;

public class tmp12 {

    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        list.add("F1");
        list.add("F2");
        list.add("F3");

        // 这是一个迭代器使用的过程
        // 有用的连接 https://www.cnblogs.com/snowater/p/8024776.html
        for (String s : list) {
            String tmp = s;
            if (list.contains(tmp)) {
                list.remove(tmp);
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
