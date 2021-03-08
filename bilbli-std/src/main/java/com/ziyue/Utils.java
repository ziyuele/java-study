package com.ziyue;

public class Utils {

    public static void print2DArr(int arr[][]) {
        for (int a = 0; a < arr.length; a ++) {
            for (int b = 0; b < arr[a].length; b ++) {
                System.out.print(arr[a][b] + "\t");
            }
            System.out.println();
        }
    }
}
