package com.ziyue.niuke.hw;

import java.util.Scanner;

public class HJ012 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int a = s.length()  -1; a>= 0; a--) {
                System.out.print(s.charAt(a));
        }
    }
}
