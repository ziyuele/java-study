package com.kangjian.springbootstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClass {
    private final Logger LOG = LoggerFactory.getLogger(TestClass.class);

    @Autowired
    private ReadConf readConf;

    @Test
    public void Test(){
        LOG.info("this is a test");
    }
}
