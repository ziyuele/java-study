package com.kangjian.designpattern.IteratorModule;

/**
 * 集合元素描述
 */
public class Book {
    private String name;
    public Book(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
