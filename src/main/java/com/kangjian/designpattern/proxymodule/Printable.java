/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.proxymodule;

public interface Printable {
    void setPrinterName(String name);

    String getPrinterName();

    void print(String string);
}
