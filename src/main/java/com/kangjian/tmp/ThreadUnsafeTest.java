/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;


public class ThreadUnsafeTest {


    class TestRunnable implements Runnable {

        private int x = 0;

        @Override
        public void run() {
            x ++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }


    public void createThread() {
        TestRunnable testRunnable = new TestRunnable();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
        System.out.println(testRunnable.getX());
        System.out.println(testRunnable.x);
    }
    public static void main(String args[]) {
       new ThreadUnsafeTest().createThread();
    }

}
