/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class tmp12Test {


    @Test
    public void test1() {
        String name = null;
        log.info(name.isEmpty() + "");
        String name1 = "";
        log.info(name1.isEmpty() + "");
    }

    @Test
    public void testReplace() {

        String url = "/apis/v1alpha1/management/${domain}/ak/${baasRole}/list";
        String res = url.replaceAll("\\$\\{domain\\}", "SEARCHE")
                .replaceAll("\\$\\{baasRole\\}", "beehive_rd");
        System.out.println(url);
        System.out.println("---------------");
        System.out.println(res);
    }


    @Test
    public void testString() {
        String tmp = ",";
        System.out.println(tmp.split(",").length);
        List<String> baasRoleList =  Arrays.asList(tmp.trim().split(","));
        System.out.println(baasRoleList.size());
        System.out.println(baasRoleList.contains(""));
    }


    @Test
    public void testIsEmpty() {
       String s = "";
       String ss = null;
       System.out.println(s.isEmpty());
    }
}