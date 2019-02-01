package com.kangjian.reflect;


public class Main {
    public static void main(String args[]) {
        /*
         *  1) using Class.forName()
         */
        Class c = null;
        try {
            c = Class.forName("com.kangjian.reflect.ClassDemo");
        } catch (ClassNotFoundException e) {
            //log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

        System.out.println(c);

        /*
         *  2) using Object.class
         */

        System.out.println(ClassDemo.class);

        /*
         *  3) using instance.getClass
         */

        ClassDemo classDemo = new ClassDemo();

        System.out.println(classDemo.getClass());

    }
}


