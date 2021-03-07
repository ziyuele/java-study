package com.ziyue.niuke.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *  原题见：
 *  https://www.nowcoder.com/practice/64f6f222499c4c94b338e588592b6a62?tpId=37&tqId=21328&rp=1&ru=%2Fta%2Fhuawei%2F&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class HW105 {

    public static void main(String args[]) {
        List<Double> integerList = new ArrayList<>();
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 0) {
                count++;
            } else {
                integerList.add(num + 0D);
            }
        }
        double ret = integerList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(count);
        System.out.println(String.format("%.1f", ret));
    }
}
