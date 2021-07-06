package com.ziyue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class CanPartition {

    @Test
    public void doTest() {
       int arr[] = {1,5,10,6};
       System.out.println(solutionA(arr));
    }

    public boolean solutionA(int arr[]) {
        // dp[0][...] 当取入的数字个数为0 时， 没有期望结果
        // dp[...][0]
        int destNum = (Arrays.stream(arr).sum())/2;
        // 不能整除， 即无法等分
        if (destNum * 2 < Arrays.stream(arr).sum()) {
           return false;
        }
        int total = arr.length;
        boolean[][] dp = new boolean[destNum + 1][total+1];
        // 初始化basecase，
        for (int a = 0; a < arr.length; a ++) {
            if (arr[a] < destNum) {
                dp[arr[a]][a + 1] = true;
            }
        }
        for (int a = 1; a <= destNum; a ++) {
            for (int b = 1; b <= total; b ++) {
                int currentNum = arr[b -1];
                if(currentNum == a) {
                    dp[a][b] = true;
                    continue;
                }
                if (currentNum < a) {
                    dp[a][b] = (dp[a][b - 1] // 他的上一个元素是否成立
                            ||
                            dp[a - currentNum][b - 1] // 求出不加这个数的结果是不是true,如果是， 那加了这个数就也是
                    );
                }
                dp[a][b] = (dp[a][b - 1]); // 如果都不成立， 直接使用上一次计算的结果的值
            }
        }
        return dp[destNum][total];
    }
}
