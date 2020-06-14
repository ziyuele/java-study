package com.kangjian.designpattern.adaptermodule2;

public class PrintBander extends Print{
    private Bander bander;

    public PrintBander(String s){
        this.bander = new Bander(s);
    }

    @Override
    public void printWeek() {
        bander.showWithAster();
    }

    @Override
    public void printStrong() {
        bander.showWithParen();
    }
}
