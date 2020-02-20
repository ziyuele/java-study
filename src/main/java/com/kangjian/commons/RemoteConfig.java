/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.commons;

import com.kangjian.commons.zk.ZKSession;
import com.kangjian.commons.zk.ZKSessionImpl;

public class RemoteConfig {

    private ZKSession zkSession;
    Configure configure = Configure.get();
    private static  final  RemoteConfig remoteConfig = new RemoteConfig();

    public static RemoteConfig get() {
       return remoteConfig;
    }

    private RemoteConfig() {
       zkSession = new ZKSessionImpl(configure.getZookeeperAddr() + ":" + configure.getZookeeperPort(),
               configure.getzkSessionTimeout());
    }

    public String getRocketMQConfig() {
       return zkSession.get(configure.getMQConfig());
    }
}
