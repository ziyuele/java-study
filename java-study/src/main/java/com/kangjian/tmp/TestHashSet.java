/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestHashSet {

    public static void main(String args[]) {
        DEMO d = DEMO.DOME;
        System.out.println(d.toString());
    }

    public static boolean containsBaasRole(String baasRoles, String targetBaasRole) {
        List<String> baasRoleList =  Arrays.asList(baasRoles.trim().split(","));
        if (baasRoleList.contains(targetBaasRole) || baasRoleList.contains("ALL")) {
            return !targetBaasRole.isEmpty();
        }
        return false;
    }
    enum DEMO{
        TEST,
        DOME,
    }
    Socket socket = new Socket();
}
