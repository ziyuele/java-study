/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.lang.reflect.Method;

public class InvokeMethod {
    public static void main(String args[]) {
        try {
            InvokeMethod invokeMethod = (InvokeMethod) InvokeMethod.class.getClassLoader().loadClass("com.kangjian.tmp"
                    + ".InvokeMethod")
                    .newInstance();
           Method method =  invokeMethod.getClass().getMethod("test");

           method.invoke(invokeMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
        System.out.println("try do do some thing");
    }

}
