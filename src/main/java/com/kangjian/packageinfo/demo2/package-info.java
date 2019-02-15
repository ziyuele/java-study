package com.kangjian.packageinfo.demo2;

class PkgClass{
    // is this usage is right??
    public static void test() {
        System.out.println("this is a global function");
    }
}

class PkgConst{
    static final String PACKAGE_INFOS = "this is global value";
}