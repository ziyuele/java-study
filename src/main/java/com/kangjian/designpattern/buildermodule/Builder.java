/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.buildermodule;

public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String string);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
