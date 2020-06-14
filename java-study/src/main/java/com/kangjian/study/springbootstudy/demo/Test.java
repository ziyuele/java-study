/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.springbootstudy.demo;

public class Test {
    private ReadConf readConf;

    private static Test test;
    public void init() {
        test = this;
        test.readConf = this.readConf;
    }

    //public static ReadConf getReadConf(){
    //    return test.readConf;
    //}
}
