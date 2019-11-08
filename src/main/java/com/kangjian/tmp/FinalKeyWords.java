/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.concurrent.GuardedBy;

public class FinalKeyWords {

    private final List<String> list;

    public FinalKeyWords() {
        this.list = new ArrayList<>();
    }

    public void add(String s) {
        list.add(s);
    }

    public List<String> get() {
        return list;
    }

    public void print(){
        System.out.println(list);
    }

    public static void main(String args[]) {
        FinalKeyWords finalKeyWords = new FinalKeyWords();
        finalKeyWords.add("ddd");
        finalKeyWords.print();
        List<String> list1 = finalKeyWords.get();
        list1.add("dasd");
        finalKeyWords.print();
    }
}
