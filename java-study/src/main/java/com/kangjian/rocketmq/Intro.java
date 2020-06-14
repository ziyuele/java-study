/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.rocketmq;

import com.kangjian.commons.RemoteConfig;

public class Intro {
    public static void main(String args[]) {
        System.out.println(RemoteConfig.get().getRocketMQConfig());
    }
}
