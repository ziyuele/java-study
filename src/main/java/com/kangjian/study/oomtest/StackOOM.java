/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.study.oomtest;

public class StackOOM {

    public static void main(String args[]) {

        while ( true ) {
            new Thread(() -> {
                while ( true ) {

                }
            }).start();
        }
    }
}
