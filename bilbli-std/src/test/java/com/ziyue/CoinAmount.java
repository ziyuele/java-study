package com.ziyue;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * eg.
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 */

public class CoinAmount {

   Map<Integer, Integer> tmpSave = new HashMap<>();

   @Test
   public void toTest() {
       int arr[] = {1,2,5 };
       //System.out.println(solutionA(arr, 11));
      System.out.println(solutionB(arr, 11));
      System.out.println(solutionC(arr, 11));
   }

   // 解法一： 暴力解法
   public int solutionA(int[] arr, int amout) {
      // 1. 明确base case及边界
      if (amout < 0) {
         return -1;
      }
      if (amout == 0) {
         return 0;   // 本次amout 不在有剩余了
      }
      int ret = Integer.MAX_VALUE;
      // 2. 写出状态转移方程
      for (int x : arr) {
         int res = solutionA(arr, amout - x);
         // 取最优解
         if (res >= 0) {
            ret = Math.min(ret, res +1);
         }
      }
      return ret == Integer.MAX_VALUE ? -1 : ret;
   }

   // 解法二： 引入dp数组(即备忘录，解决重复计算问题)
   // 这个推算过程， 属于自定向下的推演过程

   public int solutionB(int[] arr, int amout) {
      // 1.dp函数， 备忘录检查
      if (tmpSave.containsKey(amout)) {
         return tmpSave.get(amout);
      }
      // 1. 明确base case及边界
      if (amout < 0) {
         return -1;
      }
      if (amout == 0) {
         return 0;   // 本次amout 不在有剩余了
      }
      int ret = Integer.MAX_VALUE;
      // 2. 写出状态转移方程
      for (int x : arr) {
        int res = solutionB(arr, amout - x);
         // 取最优解
         if (res >= 0) {
            ret = Math.min(ret, res +1);

         }
      }
      // 添加备忘录
      int res =  ret == Integer.MAX_VALUE ? -1 : ret;
      tmpSave.put(amout, res);
      return res;
   }

   // 解法三： 自低向上的计算过程
   public int solutionC(int[] arr, int amount) {
      // 1. dp 函数
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      // 初始化 base case
      dp[0] = 0;
      for (int a = 0; a < dp.length; a ++) {
         for (int x : arr)  {
            if (a - x < 0) continue;
            dp[a] = Math.min(dp[a], 1 + dp[a - x]); //(加的这个1是amout的最小面额)
         }
      }
      return dp[amount] == amount + 1 ? -1: dp[amount];
   }
}
