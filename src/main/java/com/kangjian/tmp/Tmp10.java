package com.kangjian.tmp;

public class Tmp10 {

    public static void main (String args[]) {
        System.out.println(2/5f);

        String BNS_API_URL = "http://bns.noah.baidu.com/webfoot/index.php";
        String BNS_GET_INSTANCE_TEMPLATE = BNS_API_URL + "?r=webfoot/GetInstanceInfo&serviceName=%s";
        String s = "http://bns.noah.baidu.com/webfoot/index.php";
        String ss = "pd.www.hb";

        String res = String.format(BNS_GET_INSTANCE_TEMPLATE, ss);
        System.out.println(res);
        testFinal("test");
    }

    public static void testFinal(final String s) {
        System.out.print(s);
    }
}
