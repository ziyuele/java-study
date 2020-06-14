package com.kangjian.designpattern.templatemethodmodule;

public class Main {
    public static void main(String args[]) {
        CharDisplay display = new CharDisplay('h');
        display.display();
        StringDisplay stringDisplay = new StringDisplay("test");
        stringDisplay.display();
    }
}
