/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.vm;

public class ClinitSort {

    static class  ParentClass {
       static int A = 10;
       static {
          A = 11;
       }
    }

    static class ChildClass extends ParentClass {
       static int B = A;
    }

    /**
     *  如果没有静态代码块和变量赋值动作 clinit 也可以不执行
     * @param args
     */
    public static void main(String args[]) {
        // value should be 11;
        System.out.println(ChildClass.B);
    }
}
