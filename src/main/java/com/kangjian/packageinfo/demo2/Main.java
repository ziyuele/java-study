package com.kangjian.packageinfo.demo2;

public class Main {

    public static void main(String args[]) {
        // 存放全局函数
        PkgClass.test();
        // 存放全局的变量
        System.out.println(PkgConst.PACKAGE_INFOS);

    }
}
