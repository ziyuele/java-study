/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.oomtest;

import java.util.ArrayList;
import java.util.List;

public class PermGenOOM {
    public static void main(String args[]) {
       List<String> list = new ArrayList<>();
       int x = 0;
       while ( true ) {
          list.add(String.valueOf(x ++).intern());
       }
    }
}
