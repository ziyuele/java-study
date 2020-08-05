package com.kangjian.tmptestmt;

import com.kangjian.util.TestObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test202008 {

    @Test
    public void testCollect() {
        List<TestObject> testObjectList = new ArrayList<>();
        testObjectList.add(new TestObject("jiankang", "1"));
        testObjectList.add(new TestObject("jiankang", "1"));
        testObjectList.add(new TestObject("jiankang", "2"));
        testObjectList.add(new TestObject("test", "1"));
        Map<Object, List<TestObject>> map = testObjectList.stream().collect(Collectors.groupingBy(v -> {
            return v.getAge() + v.getName();
        }));
        System.out.println(map);
    }
}
