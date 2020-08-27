package com.kangjian.tmptestmt;

import com.google.errorprone.annotations.SuppressPackageLocation;
import com.kangjian.util.TestObject;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Test202008 {

    @Test
    public void testCollect() {
        List<TestObject> testObjectList = new ArrayList<>();
        testObjectList.add(new TestObject("jiankang", 4));
        testObjectList.add(new TestObject("jiankang", 3));
        testObjectList.add(new TestObject("jiankang", 2));
        testObjectList.add(new TestObject("test", 1));
        Map<Object, List<TestObject>> map = testObjectList.stream().collect(Collectors.groupingBy(v -> {
            return v.getAge() + v.getName();
        }));
        log.info(testObjectList.toString());
        testObjectList.sort((r1, r2) -> (r1.getAge() - r2.getAge()));
        log.info(testObjectList.toString());
        Map<String, Integer> ret = testObjectList.stream().collect(Collectors.toMap(testObject -> (testObject.getName()),
                testObject -> (testObject.getAge()),
                (t1, t2) -> {
                   return t1 + t2;
                }));
        log.info(ret.toString());
    }


    @Test
    public void testMinuteOfDay() {
        System.out.println(new DateTime().minuteOfDay().get());
    }


    @Test
    public void testGroupBy() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("klangjian", "dd");
        hashMap.put("dfdf", "werqwer");
        HashMap<String, String> hashMap1 = new HashMap<String, String>();
        log.info(hashMap1.hashCode() + "");
        hashMap1 = hashMap;
        log.info(hashMap1.hashCode() + "");
        log.info(hashMap.hashCode() + "");
    }

    @Test
    public void testSort() {
        List<String> list  = new ArrayList<>();
        list.add("ddd");
        list.add("a");
        list.add("ccccc");
        list.add("==");
        list.sort(Comparator.comparingInt(String::length));
        log.info(list.toString());
        list.forEach(s -> log.info(s));
    }

    @Test
    public void testDate() {
        log.info(new DateTime().plusDays(1).toString());
    }

    @Test
    public void testHex() {
        String s = "hello,world \n";
        for (int a = 0; a < s.length(); a++) {
           System.out.print(Integer.toHexString(s.charAt(a) + 0));
        }
    }

    @Test
    public void testDecrise() {
        Map<String, String > map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("kangjain", "aaa");
        map = map1;
        map.put("aaa", "kj");
        System.out.println(map);
    }
}
