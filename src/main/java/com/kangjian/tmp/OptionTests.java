/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionTests {
    public static void main(String args[]) {
        String s = "kangjian";
        System.out.println(Optional.ofNullable(s));
        LinkedList<String> list = new LinkedList<>();
        list.addLast("kangjian");
        list.addLast("ddd");
        list.add(1, "adad");
        System.out.println(list.toString());
    }

}
