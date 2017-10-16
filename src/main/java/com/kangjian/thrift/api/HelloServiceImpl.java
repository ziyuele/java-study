package com.kangjian.thrift.api;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String hello(String name) throws TException {
        String s = "--------------------------\n" +
                   "-                        -\n" +
                   "-     "+ name +"    -\n"+
                   "-                        -\n"+
                   "--------------------------";
        return s;
    }
}
