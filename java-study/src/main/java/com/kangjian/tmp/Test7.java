package com.kangjian.tmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test7 {

    public static void main(String args[]) throws Exception{
        System.out.println(
        new BufferedReader(new InputStreamReader(
        Test7.class.getClass().getResourceAsStream("test"))).readLine());
    }
}
