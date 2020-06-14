/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.proxymodule;

public class Main {

    public static void main(String args[]) {
        Printable p = new PrinterProxy("alice");

        p.setPrinterName("Bob");

        p.print("hello world");
    }
}
