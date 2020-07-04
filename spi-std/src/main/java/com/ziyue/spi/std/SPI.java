package com.ziyue.spi.std;

import com.ziyue.spi.std.service.TestSpi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPI {
    public static void main(String args[]) {

        // TODO-kj add a document
        ServiceLoader<TestSpi> serviceLoader = ServiceLoader.load(TestSpi.class);
        Iterator<TestSpi> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            TestSpi testSpi = iterator.next();
            testSpi.println("test spi");
        }
    }
}
