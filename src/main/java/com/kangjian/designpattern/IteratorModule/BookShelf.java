package com.kangjian.designpattern.IteratorModule;

public class BookShelf implements Aggreate{
    private Book[] books;
    private int last = 0;
    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last ++;
    }
    public int getLength(){
        return last;
    }

    @Override
    public Iteratorr iteratorr(){
        return new BookShelfIteratorr(this);
    }
}
