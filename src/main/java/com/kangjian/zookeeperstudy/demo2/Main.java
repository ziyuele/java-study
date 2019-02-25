package com.kangjian.zookeeperstudy.demo2;

import org.apache.zookeeper.ZooKeeper;

public class Main {
    public static void main(String args[]) {
        Config config = new Config();
        ZKSessionImpl session = new ZKSessionImpl();
        session.createClient(config.getHostPort(), config.getTimeOut());
        session.create(config.getPath());
    }
}
