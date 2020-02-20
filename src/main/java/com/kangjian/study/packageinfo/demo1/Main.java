package com.kangjian.study.packageinfo.demo1;

import java.lang.annotation.Annotation;

public class Main {

    public static void main(String args[]) {
       String packageName = "com.kangjian.study.packageinfo.demo1";

       Package pkg = Package.getPackage(packageName);

       Annotation [] annotations = pkg.getAnnotations();
       for (Annotation annotation : annotations) {
           if (annotation instanceof PKGAnnotation) {
               System.out.println(annotation.toString());
           }
       }
    }
}
