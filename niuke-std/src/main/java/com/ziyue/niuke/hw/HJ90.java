package com.ziyue.niuke.hw;

import java.util.Scanner;

public class HJ90 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String   s     = scanner.nextLine();
            String[] slist = s.split("\\.");
            if (slist.length != 4) {
                System.out.println("NO");
                continue;
            }
            String ret = "YES";
            for (String st : slist) {
                try {
                    if (st.contains(" ") || Integer.parseInt(st) > 255 || Integer.parseInt(st) < 0) {
                        ret = "NO";
                        break;
                    }
                } catch (Exception e) {
                    ret = "NO";
                    break;
                }
            }
            System.out.println(ret);
        }
    }
}
