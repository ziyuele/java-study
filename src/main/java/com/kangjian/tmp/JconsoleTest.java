package com.kangjian.tmp;

public class JconsoleTest {

    public static void createBusyThread() {
      Thread thread = new Thread(new Runnable() {
          @Override
          public void run() {
              while ( true ) {
                  System.out.println("RUNNING");
              }

          }
      }, "busyThread");
      thread.start();
    }

    public static void main(String args[]) {
       createBusyThread();
    }

}
