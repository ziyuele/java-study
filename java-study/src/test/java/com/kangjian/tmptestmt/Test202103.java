package com.kangjian.tmptestmt;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Test202103 {


    @Test
    public void testStringFormat() {
        double num = 3d;
        System.out.println(String.format("%.1f", num));
    }
}
