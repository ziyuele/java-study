/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    void test() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask sumTask = new SumTask(1, 10);
        int ret = forkJoinPool.invoke(sumTask);
        System.out.println(ret);
    }

    private class SumTask extends RecursiveTask<Integer> {
        private int start;
        private int end;
        private final int SUM_BATCH = 2;

        private SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int ret = 0;
            if (end - start < SUM_BATCH) {
                for (int i = start; i <= end; i ++) {
                   System.out.println("Execute sum task: " +  i);
                   ret += i;
                }
            } else {
                int middle = (end + start) / 2;
                SumTask left = new SumTask(start, middle);
                SumTask right = new SumTask(middle + 1, end);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
            return ret;
        }
    }

    public static void main(String args[]) {
       new ForkJoinTest().test();
    }
}
