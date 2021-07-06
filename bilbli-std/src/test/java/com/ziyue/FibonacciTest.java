package com.ziyue;

import org.junit.Test;

public class FibonacciTest {

    // 0, 1, 1, 2, 3, 5，8 ，13
    @Test
    public void getFib() {
        int num = 6;
        System.out.println(solutionA(num));
        System.out.println(solutionB(num, new int[num + 1]));
        System.out.println(solutionC(num));
        System.out.println(solutionD(num));
    }

    // 解法一： 暴力解法
    public int solutionA(int num) {
        if (num <= 2) {
           return num - 1;
        }
        return solutionA(num -1) + solutionA(num - 2);
    }

    // 解法二： 带备忘录的递归算法, 去掉重复计算
    // 自定向下推出的过程。
    public int solutionB(int num, int[] arr) {
        if (num <= 2) {
            arr[num] = num -1;
            return num - 1;
        }
        int ret = solutionB(num -1, arr) + solutionB(num -2, arr);
        arr[num] = ret;
        return ret;
    }

    // 解法三：自低向上的递归数组， 去除了递归
    public int solutionC(int num) {
        // dp 数组 (空间换时间，用来存储计算结果)
        int[] arr = new int[num + 1];
        // 初始化base case
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 3; i <= num; i++) {
           arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[num];
    }

    // 解法四：优化存储结果，介绍数组开辟

    public int solutionD(int num) {
        // dp 数组和 base case 重合
        int pre = 0;
        int current = 1;
        if (num <= 2) {
            return num - 1;
        }
        for (int a = 3; a <= num; a ++) {
            int next = pre  + current;
            pre = current;
            current = next;
        }
        return current;
    }
}
