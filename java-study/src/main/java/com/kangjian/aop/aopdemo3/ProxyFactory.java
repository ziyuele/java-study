/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private static PrintService printService = new PrintServiceImpl();

    public static PrintService getInstance() {

          return (PrintService)Proxy.newProxyInstance(printService.getClass().getClassLoader(),
                printService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws  Exception {
                        if (method.isAnnotationPresent(PrintMsg.class)) {
                            PrintMsg printMsg = method.getAnnotation(PrintMsg.class);
                            System.out.println(printMsg.value());
                        }
                        Object o = method.invoke(printService, args);
                        System.out.println("method used");
                        return o;
                    }
                });
    }
}
