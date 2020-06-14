/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.proxymodule;

public class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy(){}

    public PrinterProxy(String name) {
        this.name = name;
    }

    public synchronized void setName(String name) {
        if (null != real) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public void setPrinterName(String name) {
       realize();
       real.setPrinterName(name);
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private  synchronized void realize(){
        if (real == null) {
            real = new Printer(name);
        }
    }
}
