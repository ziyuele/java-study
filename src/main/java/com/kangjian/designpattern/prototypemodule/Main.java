package com.kangjian.designpattern.prototypemodule;

public class Main {
    public static void main(String args[]){
       Manager manager = new Manager();
       UnderlinePen underlinePen = new UnderlinePen('=');
       MessageBox messageBox = new MessageBox('*');

       manager.register("test", underlinePen);
       manager.register("test1", messageBox);

       Product p1 = manager.create("test");
       p1.use("asdfsaf");
       Product p2 = manager.create("test1");
       p2.use("asdfasfsdfasdfasd");

    }
}
