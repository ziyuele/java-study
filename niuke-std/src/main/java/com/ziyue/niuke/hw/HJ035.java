package com.ziyue.niuke.hw;

import java.util.Scanner;

/**
 * 00 01 02 03
 * 10 11 12 13
 * 20 21 22 23
 * 30 31 32 33
 * <p>
 * 00, 10, 01, 20, 11, 02, 30, 21, 12, 03
 * <p>
 * 1 = 1  1
 * 2 = 4  3
 * 3 = 9  6
 * 4 = 16 10
 * 5 = 25 15
 * 原题见：
 * https://www.nowcoder.com/practice/649b210ef44446e3b1cd1be6fa4cab5e?tpId=37&&tqId=21258&rp=1&ru=/ta/huawei/&qru=/ta/huawei/question-ranking
 */

public class HJ035 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int num     = Integer.parseInt(scanner.nextLine());
            int arr[][] = new int[num][num];
            int cont    = 1;
            int preY    = 0;
            int x       = 0;
            int y       = 0;
            while (preY < num) {
                arr[x][y] = cont++;
                if (y - 1 < 0) {
                    y    = preY + 1;
                    preY = y;
                    x    = 0;
                } else {
                    y--;
                    x++;
                }
            }
            for (int a = 0; a < arr.length; a++) {
                for (int b = 0; b < arr[a].length; b++) {
                    if (arr[a][b] == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(arr[b][a] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
