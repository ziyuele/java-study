package com.ziyue.spi.std.service.impl;

import com.ziyue.spi.std.service.TestSpi;

public class TestSpiImplOne implements TestSpi {

    @Override
    public void println(String s) {
        System.out.println("============================");
        System.out.println(s);
        System.out.println("============================");
    }
}
