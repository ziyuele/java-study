package com.kangjian.designpattern.templatemethodmodule;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StringDisplay extends AbstractDisplay{

    private static final Logger LOG = LoggerFactory.getLogger(StringDisplay.class);
    private String string;
    private int width;

    public StringDisplay(String string) {
       this.string = string;
       this.width = string.getBytes().length;
       LOG.info("this.width is :{}", this.width);
       LOG.info("String length is {}", string.length());

    }

    @Override
    public void open() {
       printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine(){
        System.out.print("+");
       for (int x = 0; x < this.width; x++){
           System.out.print("-");
       }
       System.out.println("+");
    }
}
