package com.kangjian.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * 处理了参数有状态
 */
public class Stream03 {


    public static void main(String args[]) {
        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("zhangsan", "lisi", "wangmazi"));
        List<String> res = list.parallelStream().map(e -> {
            if (Test.value) {
                return "hh";
            } else {
                Test.value = true;
                return "dd";
            }
        }).collect(Collectors.toList());
        System.out.println(res);
    }

    static class Test {
        public static boolean value = false;

    }
}
