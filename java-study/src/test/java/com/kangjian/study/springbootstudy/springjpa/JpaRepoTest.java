/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.springbootstudy.springjpa;


import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@SpringBootTest
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaRepo.class})
public class JpaRepoTest {


    @Autowired
    private JpaRepo jpaRepo;

    private static TableBean tableBean;
    @BeforeClass
    public static void beforeClass() {
        tableBean = new TableBean();
        tableBean.setAge("29");
        tableBean.setId(1);
        tableBean.setName("kangjian");
    }

    @Before
    public void setUp() {
       jpaRepo.deleteAll();
    }

    @Test
    public void save() {
        jpaRepo.save(tableBean);
        TableBean tableBean1 = jpaRepo.findByAge("29");
        log.info(tableBean1.toString());
        Assert.assertEquals(tableBean, tableBean1);
    }

    @Test
    public void deleteById() {
        jpaRepo.save(tableBean);
        jpaRepo.deleteById(tableBean.getId());
        TableBean tableBean1 = jpaRepo.findByAge(tableBean.getAge());
        Assert.assertNull(tableBean1 );
    }

    @Test
    public void deleteByName() {
        jpaRepo.save(tableBean);
        jpaRepo.deleteByName(tableBean.getName());
        TableBean tableBean1 = jpaRepo.findByAge(tableBean.getAge());
        Assert.assertNull(tableBean1 );
    }

    @Test
    public void findAllByAge() {
        jpaRepo.save(tableBean);
        List<TableBean> tableBeanList = jpaRepo.findAllByAge(tableBean.getAge());
        log.info(tableBeanList.toString());
        Assert.assertEquals(tableBeanList.size(), 1);
    }

    @Test
    public void get() {
        jpaRepo.save(tableBean);
        List<TableBean> tableBeans = jpaRepo.get();
        log.info(tableBeans.toString());
        Assert.assertEquals(tableBeans.size(), 1);
    }
}