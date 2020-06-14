package com.kangjian.designpattern.templatemethodmodule;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display(){
       open();
       for (int x = 0; x < 5; x++ ) {
           print();
       }
       close();
    }
}
