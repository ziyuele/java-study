/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {
    public static void main(String args[]) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(new ForkJoinThread());
    }

    static class ForkJoinThread implements Runnable {
        @Override
        public void run() {
            System.out.println("test");
        }
    }
}
