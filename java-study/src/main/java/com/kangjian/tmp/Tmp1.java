package com.kangjian.tmp;

import java.util.List;

/**
 * array init
 */
public class Tmp1 {
    public static void main(String args[]){
      List list = null;
      try {
         throw  new RuntimeException("dfsa");
      } catch (RuntimeException e) {
          System.out.println("safda");
      }finally {
          System.out.println("sdfdf");
      }

      Tmp1 tmp1 = new Tmp1();
      System.out.println(tmp1.getClass().getName().contains("com.kangjian"));

    }
}
