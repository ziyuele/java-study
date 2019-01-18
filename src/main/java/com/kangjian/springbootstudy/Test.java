package com.kangjian.springbootstudy;

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
