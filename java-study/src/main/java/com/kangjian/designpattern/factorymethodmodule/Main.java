package com.kangjian.designpattern.factorymethodmodule;

public class Main {
    public static void main(String args[]){
        Fractory factory = new IDCardFactory();
        IDCard card1 =  (IDCard) factory.create("one");
        IDCard card2 = (IDCard) factory.create("two");
        IDCard card3 = (IDCard) factory.create("three");
        card1.use();
        card2.use();
        card3.use();
    }
}
