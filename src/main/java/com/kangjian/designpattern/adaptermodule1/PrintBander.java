package com.kangjian.designpattern.adaptermodule1;

public class PrintBander extends Bander implements Print{
    public PrintBander(String string){
        super(string);
    }

    @Override
    public void printWeek() {
        showWithAster();
    }

    @Override
    public void printStrong() {
        showWithParen();
    }
}


