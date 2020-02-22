/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.commons;

import java.io.IOException;
import java.util.Properties;

public class Configure {


    private static final Configure configure = new Configure();
    private static Properties properties;

    public static Configure get() {
        return configure;
    }

    private Configure() {
        properties = new Properties();
        try {
            properties.load(Configure.class.getClassLoader().getResourceAsStream("study.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getZookeeperAddr() {
        return properties.getProperty("study.zookeeper.addr", "127.0.0.1");
}

    public int getZookeeperPort() {
        String properityKey = "study.zookeeper.port";
        return Integer.parseInt(properties.getProperty(properityKey, "8181"));
    }

    public int getzkSessionTimeout() {
        return Integer.parseInt(properties.getProperty("study.zookeeper.timeout", "3000"));
    }

    public String getMQConfig() {
        return properties.getProperty("study.mq.zk.path", "/tet/");
    }

    public String getSyncTopic() {
        return properties.getProperty("study.mq.sync.topic", "syncTopic");
    }

    public String getMQGroup() {
        return properties.getProperty("study.mq.group", "testGroup");
    }

}
