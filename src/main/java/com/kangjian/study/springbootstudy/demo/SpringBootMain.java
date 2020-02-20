/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.springbootstudy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class SpringBootMain {

    @Autowired
    private ReadConf readConf;

    public static void main(String args[]) {
       SpringApplication.run(SpringBootMain.class, args);
    }
}
