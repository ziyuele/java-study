package com.kangjian.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * // @Documented –注解是否将包含在JavaDoc中
 * // @Retention –什么时候使用该注解
 * // @Target? –注解用于什么地方
 * // @Inherited – 是否允许子类继承该注解
 *
 */


@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    public int print();
}
