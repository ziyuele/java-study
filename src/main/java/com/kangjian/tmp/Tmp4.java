package com.kangjian.tmp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * timestamp to date
 */

public class Tmp4 {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String args[]) throws ParseException {
        Long x = System.currentTimeMillis();
        System.out.println(x);
        String s = x + "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  res  = simpleDateFormat.format(System.currentTimeMillis() / 1000);
        System.out.println(res);

        System.out.println(millsToReadableLocalTime(System.currentTimeMillis()));
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
        System.out.println(setTimeSeconds(System.currentTimeMillis()));
    }


    public static String millsToReadableLocalTime(long mills) {
        Date date = new Date();
        date.setTime(mills);
        return dateFormat.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.of("Asia/Shanghai")));
    }

    private static long setTimeSeconds(long timeStamp){
        long  timeMaxSecond = 9999999999L;
        if (timeStamp  > timeMaxSecond) {
            return timeStamp / 1000;
        } else {
            return timeStamp;
        }
    }
}
