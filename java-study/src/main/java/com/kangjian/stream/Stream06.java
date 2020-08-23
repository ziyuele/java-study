package com.kangjian.stream;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Stream06 {
    public static void main(String args[]) {
        // distinct 使用示例
        List<String> list = Stream.of("a", "b", "c", "c", "c", "d").distinct().collect(Collectors.toList());
        log.info(list.toString());

        // filter 使用示例
        List<Integer> integerslist = Stream.of(1, 3, 4, 5, 7, 9).filter(o -> o > 4).collect(Collectors.toList());
        log.info(integerslist.toString());

        // map 操作实力
        List<Integer> numList = Stream.of("kangjian", "dd", "a").map(String::length).collect(Collectors.toList());
        log.info(numList.toString());

        // flatmap 操作示例
        List<String> flatMapList =
                Stream.of("kangjian is", "a", "good boy").flatMap(o -> Arrays.stream(o.split(" "))).collect(Collectors.toList());
        log.info("size is: {}, detail is: {}", flatMapList.size(), flatMapList.toString());

        // limit 操作实例
        List<String> limitList = Stream.of("a", "b", "c", "d").limit(3).collect(Collectors.toList());
        log.info(limitList.toString());

        // peek 操作实例
        Stream<String> stringStream = Stream.of("a", "b", "c", "d");
        stringStream.peek(log::info).collect(Collectors.toList());

        // sorted操作示例
        Stream<Character> sorted        = Stream.of('d', 'c', 'b', 'a');
        List<Character>   characterList = sorted.sorted((o1, o2) -> o1 - o2).collect(Collectors.toList());
        log.info(characterList.toString());

        // skip 操作示例
        Stream<String> stringStream1 = Stream.of("kk", "dd", "jim", "tim");
        List<String> stringList = stringStream1.skip(2).collect(Collectors.toList());
        log.info(stringList.toString());

        // concat 操作示例
        Stream<String> concat1 = Stream.of("a", "b");
        Stream<String> concat2 = Stream.of("c", "d");
        List<String> concatList = Stream.concat(concat1, concat2).collect(Collectors.toList());
        log.info(concatList.toString());
    }
}
