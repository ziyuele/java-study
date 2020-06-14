package com.kangjian.tmptestmt;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

@Slf4j
public class Test202006 {

    @Test
    public void testTime() {
        Date date = new Date();
        log.info(date.toString());
        DateTime dateTime = new DateTime(date.getTime());
        log.info(dateTime.toDate().toString());
        log.info(dateTime.toString("yyyyMMdd HH:mm:ss:SSS"));
        log.info(dateTime.minusDays(1).toString("yyyyMMdd HH:mm:ss:SSS"));

    }
}
