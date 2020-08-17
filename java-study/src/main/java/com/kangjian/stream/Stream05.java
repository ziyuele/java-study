package com.kangjian.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class Stream05 {
    public static void main(String args[]) {
        List<String>     list = new CopyOnWriteArrayList<>(Arrays.asList("zhangsan", "lisi", "wangmazi"));
        Optional<String> res  = list.parallelStream().reduce((a, b) -> (a + b));
        System.out.println(res);
    }
}
