package com.kangjian.tmp;

import java.io.File;
import java.net.InetAddress;

public class Tmp11 {

    public static void main(String args[]) {
        try {

            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();

        }

        File f = new File("/Users/kangjian03/t?1d");
        System.out.println(f.toPath().getClass());
    }
}
