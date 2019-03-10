/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.buildermodule;

public class TextBuilder extends Builder{

    private StringBuffer buffer = new StringBuffer();
    @Override
    public void makeTitle(String title) {
        buffer.append("==============================\n");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");

    }

    @Override
    public void makeString(String string) {
        buffer.append("| " + string + "\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            buffer.append("\n" +  item + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("==============================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
