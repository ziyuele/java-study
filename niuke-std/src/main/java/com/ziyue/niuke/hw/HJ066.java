package com.ziyue.niuke.hw;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

public class HJ066 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<String> list    = new ArrayList<>(Arrays.asList("reset", "board", "add", "delete", "backplane", "abort"));
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (list.indexOf(s) < s.length() - 1) {
                System.out.println(list.get(list.indexOf(s) + 1));
            }
        }
    }
}
