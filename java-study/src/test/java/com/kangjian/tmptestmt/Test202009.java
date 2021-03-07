package com.kangjian.tmptestmt;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Test202009 {

    @Test
    public void testDateUtil() {
        DateTime dateTime = new DateTime().withTimeAtStartOfDay();
        DateTime time = dateTime.minusDays(dateTime.getDayOfMonth() - 1);
        System.out.println(dateTime.toString("yyyy-MM-dd"));
        System.out.println(dateTime.minusDays(dateTime.getDayOfMonth() - 1).toDate());
    }

    @Test
    public void testMapJoin() {
        Boolean b = false;
        System.out.println(b.toString());
        Map<String, String> map1 = new HashMap<>();
        map1.put("test", "1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("test", "2");
    }

    @Test
    public void testDateUtil1() {
        DateTime dateTime = new DateTime().withTimeAtStartOfDay();
        DateTime dateTime1 = new DateTime().minusDays(1).withTimeAtStartOfDay();
    }
}
