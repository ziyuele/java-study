package com.kangjian.reflect;

import java.lang.reflect.Method;

public class Main {
    public static void main(String args[]) {
        /*
         *  1) using Class.forName()
         */
        Class c = null;
        try {
            c = Class.forName("com.kangjian.reflect.ClassDemo");


            // Class type ---- class type
            ClassDemo demo = (ClassDemo) c.newInstance();
        } catch (ClassNotFoundException  | InstantiationException | IllegalAccessException e) {
            //log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }


        System.out.println(c);


        System.out.println("getName:" + c.getName());

        System.out.println("---------------------------");
        /*
         *  2) using Object.class
         */

        System.out.println(ClassDemo.class);

        System.out.println("---------------------------");

        /*
         *  3) using instance.getClass
         */

        ClassDemo classDemo = new ClassDemo();

        System.out.println(classDemo.getClass());

        System.out.println("---------------------------");

        /**
         *  4) method reflect and demo
         */

        Class demo = ClassDemo.class;

        Method methods[] = demo.getMethods();

        for (Method method : methods) {
            System.out.println("function Name:" + method.getName());

            System.out.println("return type:" + method.getReturnType());

            Class paraTypes[] = method.getParameterTypes();

            for(Class parameter: paraTypes) {
                System.out.println("parameter:" + parameter);
            }
            System.out.println("+++++++++++++++++++++++++++++");
        }

    }
}


