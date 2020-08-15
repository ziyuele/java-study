package com.kangjian.stream;

/**
 *  流操作中的非线程安全的场景下可能会出现的问题
 */

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class Stream02 {
    public static void main(String args[]) {
        List<String> l = new CopyOnWriteArrayList<>(Arrays.asList("one", "two"));
        //  如果如果替换成非线程安全的容器，那么就会抛 ConcurrentModificationException 异常
        //List<String> l = new ArrayList<>(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        // 处理过程中操作数据源
        sl.forEach(s -> l.add("d"));

        System.out.println(l);
    }
}
