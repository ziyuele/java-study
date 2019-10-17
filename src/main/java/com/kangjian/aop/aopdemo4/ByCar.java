/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.aop.aopdemo4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ByCar {
    String msg() default  "this is a new car";
}
