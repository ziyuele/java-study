package com.kangjian.tmptestmt;

import org.joda.time.DateTime;
import org.junit.Test;

public class Test202009 {

    @Test
    public void testDateUtil() {
        DateTime dateTime = new DateTime().withTimeAtStartOfDay();
        DateTime time = dateTime.minusDays(dateTime.getDayOfMonth() - 1);
        System.out.println(dateTime.toString("yyyy-MM-dd"));
        System.out.println(dateTime.minusDays(dateTime.getDayOfMonth() - 1).toDate());
    }
}
