/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.zookeeperstudy.demo2;

import lombok.Getter;

/**
 * this class is used to get setting file
 *
 * host and port is my personal machine
 * if any one want to connect my zookeeper
 * please send mail to: 2029362606@qq.com
 *
 */

@Getter
public class Config {
    private final String hostPort = "140.143.132.21:8181";
    private final String path = "/kangijan";
    private final String digestAuth = "test:test";
    private final int timeOut = 3000;
}
