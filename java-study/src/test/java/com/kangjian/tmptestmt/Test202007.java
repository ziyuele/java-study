package com.kangjian.tmptestmt;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Test202007 {

    @Test
    public void testDate() {
        DateTime dateTime = new DateTime().withTimeAtStartOfDay();
        DateTime dateTime1 = new DateTime().minusDays(1).withTimeAtStartOfDay();
        log.warn(Days.daysBetween(dateTime, dateTime1).getDays() + "");
    }

    @Test
    public void testMap() {
        List<String> list = new ArrayList<>();
        list.add("kangjian");
        list.add("ziyele");
        list.add("test");
        list.stream().map(s -> s + "   hello").collect(Collectors.toList()).forEach(s -> {
            log.warn(s);
        });
    }


    @Test
    public void testSteamOptaion() {
        List<String> list = new ArrayList<>();
        list.add("kangjian");
        list.add("ziyele");
        list.add("test");
        List<String> res = list.stream().map(this::apppendStr).collect(Collectors.toList());
        log.warn(res.toString());
    }


    @Test
    public void testFunction() {
        int ret = sum(3, vale -> vale + 1);
        log.info("ret is :{}" , ret);
        ret = sum(3, this::add);
        log.info("ret is :{}" , ret);
    }

    @Test
    public void testBiFunction() {
       int ret = sum(1, 2, this::sum);
        log.info("ret is :{}" , ret);
    }

    private int add(int a) {
        return a + 2;
    }

    public int sum(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
       return biFunction.apply(a, b);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    private String apppendStr(String s) {
       return s + "===test";
    }


    //====
    @Test
    public void testUUID() {
        String uid = UUID.randomUUID().toString();
        log.info("uid is: {}", uid);
    }
}
