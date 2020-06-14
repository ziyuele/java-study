/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.commons;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigureTest {

    @Test
    public void initProperties() {
        Configure configure = Configure.get();
        System.out.println(configure.getZookeeperPort());
        System.out.println(configure.getZookeeperAddr());
        System.out.println(configure.getMQConfig());
    }

}