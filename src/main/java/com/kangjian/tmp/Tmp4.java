package com.kangjian.tmp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * timestamp to date
 */

public class Tmp4 {
    public static void main(String args[]) throws ParseException {
        Long x = System.currentTimeMillis();
        System.out.println(x);
        String s = x + "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  res  = simpleDateFormat.format(1513585177);
        System.out.println(res);
    }
}
