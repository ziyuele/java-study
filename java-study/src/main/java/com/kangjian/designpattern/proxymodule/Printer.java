/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.proxymodule;

public class Printer implements Printable {
    private String printerName;

    public Printer(String printerName) {
        this.printerName = printerName;
        heavyJob("work generating");
    }

    @Override
    public void setPrinterName(String name) {
       this.printerName = name;
    }

    @Override
    public String getPrinterName() {
        return printerName;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + printerName + " ===");
        System.out.println(string);
    }

    void heavyJob(String s) {
       System.out.print(s);
       for(int x = 0; x < 10; x++) {
           System.out.print(".");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       System.out.println("ogay");

    }
}
