package com.kangjian.annotation;

import java.lang.reflect.Method;

public class Test {
    public static void main(String args[]){
        Test t = new Test();
        t.testAnnotation();
        Method[]  methods = t.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(TestAnnotation.class)) {
                System.out.println("this is a test get annotation is okay");
                TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
                System.out.println(testAnnotation.value());

            }
        }
    }

    @TestAnnotation(value = 3)
    private void testAnnotation() {

    }
}
