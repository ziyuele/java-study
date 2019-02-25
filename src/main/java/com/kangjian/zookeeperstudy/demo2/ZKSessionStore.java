package com.kangjian.zookeeperstudy.demo2;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public abstract class ZKSessionStore {

    /**
     * this is used to init a zookeeper to build a connection
     */
    public abstract ZooKeeper createClient(String hostPort, int sessionTimeOut);

}

