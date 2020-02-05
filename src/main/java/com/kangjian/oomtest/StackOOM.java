/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.oomtest;

import org.hibernate.hql.spi.id.TableBasedDeleteHandlerImpl;

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
