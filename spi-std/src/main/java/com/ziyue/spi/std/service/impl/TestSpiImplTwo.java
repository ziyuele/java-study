package com.ziyue.spi.std.service.impl;

import com.ziyue.spi.std.service.TestSpi;

public class TestSpiImplTwo implements TestSpi {

    @Override
    public void println(String s) {
        System.err.println("============================");
        System.err.println(s);
        System.err.println("============================");
    }
}
