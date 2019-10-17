package com.kangjian.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String args[]) throws InvocationTargetException, IllegalAccessException {

        Test t = new Test();
        //t.testAnnotation();
        Method[]  methods = t.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(TestAnnotation.class)) {
                TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
                method.invoke(t);
                System.out.println(testAnnotation.value());

            }
        }
    }

    @TestAnnotation(value = 3)
    private void testAnnotation() {
        System.out.println("this is test");
    }
}
