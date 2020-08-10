package com.kangjian.tmptestmt;

import com.google.errorprone.annotations.SuppressPackageLocation;
import com.kangjian.util.TestObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    }
}
