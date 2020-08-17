package com.kangjian.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Stream04 {

    public static void main(String[] args) {
        ArrayList<String> results = new ArrayList<>();
        List<String>      list    = new CopyOnWriteArrayList<>(Arrays.asList("zhangsan", "lisi", "wangmazi"));
        // 副作用， 不建议使用
        list.stream().filter(s -> !s.isEmpty()).forEach(s -> results.add(s));
        // 无副作用
        list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(results);
    }
}
