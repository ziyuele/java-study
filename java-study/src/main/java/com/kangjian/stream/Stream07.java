package com.kangjian.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Stream07 {
    public static void main(String args[]) {
        /**
         *  Match demo
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        boolean         b             = integerStream.anyMatch(a -> a < 0);
        log.info("ret is: {}", b);

        // 使用过的流已经关闭， 需要重新创建
        integerStream = Stream.of(1, 2, 3, 4);
        boolean c = integerStream.noneMatch(a -> a < 0);
        log.info("ret is: {}", c);

        integerStream = Stream.of(1, 2, 3, 4);
        boolean d = integerStream.allMatch(a -> a > 0);
        log.info("ret is : {}", d);

        /**
         *  count demo
         */
        Stream<Integer> contStream = Stream.of(1, 3, 4);
        long            count      = contStream.count();
        log.info("count is :{}", count);


        /**
         * collector demo
         */
        // 1. 底层实现
        Stream<String> collectStream   = Stream.of("a", "c", "b", "d");
        String         collectorString = collectStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        log.info(collectorString);

        // 2. 使用现有的collector
        Stream<String> collectStreamNew = Stream.of("a", "c", "b", "d");
        String         ret              = collectStreamNew.collect(Collectors.joining());
        log.info(ret);

        /**
         * find demo
         */
        Stream<Integer> findSteram = Stream.of(1, 3, 4, 5);
        int             num        = findSteram.findAny().get();
        log.info("num is :{}", num);
        Stream<Integer> findFirstNum = Stream.of(3, 3, 5, 5);
        int             firstNum     = findFirstNum.findFirst().get();
        log.info("first num is :{}", firstNum);

        /**
         * forEatch demo
         */
        Stream<Integer> forEatchDemo = Stream.of(1, 5, 3, 4);
        forEatchDemo.forEach(n -> log.info("num is :{}", n));

        Stream<Integer> forEatchSortedDemo = Stream.of(1, 5, 3, 4);
        forEatchSortedDemo.forEachOrdered(e -> log.info("num is : {}", e));

        /**
         * max min demo
         */
        Stream<Integer> maxSteam = Stream.of(1, 3, 4);
        int             max      = maxSteam.max((x, y) -> (x - y)).get();
        log.info("max = {}", max);

        Stream<Integer> minStream = Stream.of(1, 3, 4);
        int             min       = minStream.min(Comparator.comparingInt(x -> x)).get();
        log.info("min = {}", min);

        /**
         * reduce demo
         */
        Stream<Integer> reduceStream = Stream.of(1, 3, 4);
        int             res          = reduceStream.reduce(0, (x, y) -> x + y);
        log.info("ret is :{}", res);

        reduceStream = Stream.of(1, 3, 4);
        res = reduceStream.reduce((x, y) -> x + y).get();
        log.info("res is :{}", res);

        /**
         * toArra demo
         */
        Stream<Integer> toArrayStream = Stream.of(1,3,4);
        Object[] intArr = toArrayStream.toArray();
        log.info("res is :{}", Arrays.asList(intArr).toString());
    }
}
