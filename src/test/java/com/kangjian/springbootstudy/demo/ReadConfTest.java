/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.springbootstudy.demo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ReadConfTest {

    @Autowired
    private ReadConf conf;

    @Test
    public void getConf() {
        log.info(conf.getHost());
        Assert.assertEquals("localhost", conf.getHost());
    }
}