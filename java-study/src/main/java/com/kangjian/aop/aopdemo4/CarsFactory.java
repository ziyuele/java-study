/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CarsFactory {
    private static final BoughtInterface implents = new BoughtImplents();
   public BoughtInterface getInstance() {
         return (BoughtInterface) Proxy.newProxyInstance(BoughtImplents.class.getClassLoader(),  implents.getClass()
                 .getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.isAnnotationPresent(ByCar.class)) {
                    System.out.println(method.getAnnotation(ByCar.class).msg());
                }
                return method.invoke(implents, args);
            }
         });
   }
}
