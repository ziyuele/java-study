/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.zookeeperstudy.demo2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZKCURDTest {
    private static ZKSessionImpl session;

    @BeforeClass
    public static void beforeClass() {
        Config config = new Config();
        session = new ZKSessionImpl();
        session.createClient(config.getHostPort(), config.getTimeOut());
    }

    @Test
    public void testCreate() {
        String path = "/test";
        session.create(path);
    }


    @Test
    public void testCreate1() {
        String path = "/test";
        String data = "test_data";
        session.delete(path);
        session.create(path, data);
        String res = session.get(path);
        log.info(res);
        Assert.assertEquals(data, res);
    }

    @Test
    public void testUpdate() {
        String path = "/test";
        String data = "test_data";
        session.delete(path);
        session.create(path, data);
        session.update(path, data + data);
        String res = session.get(path);
        log.info(res);
        Assert.assertEquals(data + data, res);
    }

    @Test
    public void testDelete() {
        testCreate();
        String path = "/test";
        session.delete(path);
    }


    @Test
    public void testChild() {
       String path = "/test";
       String childPath1 = "/child1";
       String childPath2 = "/child2";
       List<String> list = new ArrayList<>();
       list.add("child2");
       list.add("child1");
       session.delete(path + childPath1);
       session.delete(path + childPath2);
       session.delete(path);
       session.create(path);
       session.create(path + childPath1);
       session.create(path + childPath2);
       List<String> res = session.child(path);
       log.info(res.toString());
       Assert.assertEquals(list.toString(), res.toString());

      session.delete(path + childPath1);
      session.delete(path + childPath2);
    }

}
