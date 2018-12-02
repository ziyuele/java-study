package com.kangjian.springbootstudy.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class Test {
    @Resource
    private ReadConf readConf;

    private static Test test;
    @PostConstruct
    public void init() {
        test = this;
        test.readConf = this.readConf;
    }

    public static ReadConf getReadConf(){
        return test.readConf;
    }
}
