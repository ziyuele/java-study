package com.kangjian.annotation;

public class Test {
    public static void main(String args[]){
        Test t = new Test();
        t.testAnnotation();
    }

    @TestAnnotation(print = 3)
    private void testAnnotation() {

    }
}
