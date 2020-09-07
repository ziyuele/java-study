package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/66ca0e28f90c42a196afd78cc9c496ea?tpId=37&&tqId=21256&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 *
 */

public class HJ033 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(".")) {
                ip2Num(line);
            } else {
                num2Ip(line);
            }
        }
    }

    public static void ip2Num(String ip) {
        String[] numStr = ip.split("\\.");
        String ret = "";
        for (String s : numStr) {
            String bstr =  Integer.toBinaryString(Integer.parseInt(s));
            if (bstr.length() < 8) {
                int end = 8 - bstr.length();
                for (int a = 0; a < end; a ++) {
                    bstr = "0" + bstr;
                }
            }
            ret += bstr;
        }

        System.out.println(Long.parseLong(ret, 2));
    }

    public static void num2Ip(String num) {
        String binayStrng = num;
        if (!num.replace("1", "").replace("0", "").equals("")) {
            binayStrng = Long.toBinaryString(Long.parseLong(num));
        }
        int len = binayStrng.length();
        String res = "";
        for (int a = 0; a < 4; a++ ) {
             int start = len - 8 > 0 ? len - 8 : 0;
             long ret = Long.parseLong(binayStrng.substring(start, len), 2);
             len = start;
             res = ret + "." +   res;
        }
        System.out.println(res.substring(0, res.length() -1));
    }
}
