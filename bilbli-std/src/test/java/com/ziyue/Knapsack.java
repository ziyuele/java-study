package com.ziyue;

import org.junit.Test;

/**
 * 假设你现在有一个容量为W的背包和N 个物品， 每个物品有重量和价值的两个属性，
 * 其中第i个物品的重量为wt[i]， 价值为val[i],
 * 现在让你用背包去装这个物品， 最多能装的价值是多少？
 * <p>
 * 例如：
 * 背包容量W = 4
 * 物品个数 N = 3
 * 每个物品的重量：wt = [2, 1,3]
 * 每个物品的价值：val = [4, 2. 3]
 * <p>
 * <p>
 * 2.1、明确[状态] 和 [选择]
 * 状态
 * 可选的物品还有那些
 * 背包的容量还剩多少
 * 选择
 * 把这个物品装进背包
 * 不把这个物品装进背包
 * 2.2、明确dp 数组的定义
 * 对于前i个物品， 当背包容量为w是， 可以装的最大价值是dp[i][w]
 * 对于上述条件描述， base case
 * dp[0][x] = dp[..][0] = 0， 我们需要求的结果是dp[n][w]
 */

/**
 *  数组关系描述
 *
 *  + 背包容量\物品数量+ 0   1    2    3
 *    0               0   0    0    0
 *    1               0   2    2    2
 *    2               0   4    4    4
 *    3               0   3    6    6
 *    4               0   4    5    6
 */
public class Knapsack {

    @Test
    public void doTest() {
        int n = 3;  // 物品个数
        int w = 4;  // 背包容量
        int[] wt = {2, 1, 3}; // 每个物品重量
        int[] val = {4, 2, 3}; // 每个物品价值
        System.out.println(solutionB(n, w, wt, val));
    }

    public int solutionA(int n, int w, int[] wt, int[] val) {
        int arr[][] = new int[n + 1][w + 1];
        //arr[0][] 0 个物品， 最大价值是0
        //arr[][0] 0 个背包， 最大价值0
        for (int a = 1; a <= n; a++) { // n 个物品
            for (int b = 1; b <= w; b++) { // x 个容量
                // 如何判断背包是否还能装的下?
                if (b - wt[a - 1] < 0) {
                    arr[a][b] = arr[a - 1][b];
                    // 求最优子结构, 求a个物品， 背包容量为b时的最大价值
                }else {
                    arr[a][b] = Math.max(
                            // 1. 装进背包
                            // b - wt[a - 1] : 当前容量 - 当前要装的重量 = 背包的剩余容量
                            arr[a - 1][b - wt[a - 1]] + val[a - 1],
                            // 2. 不装进背包， 相当于物品个数没有变， 背包容量变化了
                            arr[a - 1][b]
                    );
                }
            }
        }
        return arr[n][w];
    }


    public int solutionB(int n, int w, int[] wt, int[] val) {
        // base case : 0个物品, n 个容量， 价值是0; n个物品， m个容量价值是0, 根据上述条件， 完成初始化条件的构建
        int arr[][] = new int[w + 1][n + 1];  // 当容量为w， 物品个数为n时, 最大价值为 arr[w][n];
        //  背包容量
        for (int a = 1; a <= w; a++) {
            // 物品个数
            for (int b = 1; b <= n; b++) {
                if (a - wt[b -1] < 0) { // 判定如果装， 那么现在的这个容量能装的下么：总容量 - 要装的这个物品的重量
                    arr[a][b] = arr[a][b - 1];
                } else {
                    arr[a][b] = Math.max(
                            // 不装， 他的价值
                            arr[a][b - 1],
                            // 当前的价值 + (总容量 - 不装这个物品的重量)(不装这个物品的个数)
                            val[b - 1] + arr[a - wt[b - 1]][b -1]
                    );
                }
            }
        }
        return arr[w][n];
    }
}
