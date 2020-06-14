package com.kangjian.designpattern.adaptermodule2;

public class Main {
    public static void main(String arg[]){
        PrintBander p = new PrintBander("test");
        p.printStrong();
        p.printWeek();
    }
}
