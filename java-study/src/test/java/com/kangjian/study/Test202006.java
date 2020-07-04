package com.kangjian.study;

import org.joda.time.DateTime;
import org.junit.Test;

public class Test202006 {


    @Test
    public void testDate() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.withTimeAtStartOfDay().toString("yyyMMdd MMHHss"));
    }
}
