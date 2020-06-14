/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo3;

public interface PrintService {

    @PrintMsg("this is a test")
    public void print(String s);
}
