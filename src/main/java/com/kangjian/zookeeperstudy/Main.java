package com.kangjian.zookeeperstudy;

import org.apache.zookeeper.KeeperException;

public class Main {

    public static void main(String args[]) throws KeeperException {
        String hostPort = "140.143.132.21:8181";
        String nodepath = "/com";
        String fileName = "test_file";
        String exec = "echo test";
        new Executor(hostPort, nodepath, fileName, exec).run();
    }
}
