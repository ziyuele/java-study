package com.kangjian.designpattern.IteratorModule;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class Main {
    private static final Logger LOG =LoggerFactory.getLogger(Main.class);
    public static void main(String args[]){
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("bookName 1"));
        bookShelf.appendBook(new Book("bookName 2"));
        bookShelf.appendBook(new Book("bookName 3"));
        Iteratorr iteratorr = bookShelf.iteratorr();
        while(iteratorr.hasNext()){
            LOG.info("get book name is: 《{}》", ((Book)iteratorr.next()).getName());
        }
        LOG.info("Done...");
    }
}
