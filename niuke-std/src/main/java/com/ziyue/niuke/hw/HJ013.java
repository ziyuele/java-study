package com.ziyue.niuke.hw;

import java.util.Scanner;

public class HJ013 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        for(int a = arr.length -1 ; a>0; a --) {
           System.out.print(arr[a] + " ");
        }
        System.out.println(arr[0]);
    }
}
