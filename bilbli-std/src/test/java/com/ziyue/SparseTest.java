package com.ziyue;


import org.junit.Test;

/***
 *  稀疏数组学习
 */
public class SparseTest {
    /**
     * 创建二维数组
     *
     * @return
     */
    public int[][] create2DArr() {
        int arr[][] = {
                {0, 0, 0, 1},
                {2, 2, 0, 0},
                {3, 0, 0, 0},
                {0, 0, 0, 0},
                {3, 2, 0, 0}
        };
        return arr;
    }

    /**
     * 创建稀疏数组
     *
     * @return
     */
    public int[][] createSparseArr() {
        int arr[][] = {
                {5, 4, 6},
                {0, 3, 1},
                {1, 0, 2},
                {1, 1, 2},
                {2, 0, 3},
                {4, 0, 3},
                {4, 1, 2}
        };
        return arr;
    }

    @Test
    public void arr2SparseArr() {
        int arr[][] = create2DArr();
        // 1. 遍历找到原始数组的非0个数
        int sum = 0;
        for(int a = 0; a < arr.length; a ++) {
            for (int b = 0; b < arr[b].length; b++) {
                if (arr[a][b] != 0) {
                    sum ++;
                }
            }
        }
        // 2. 创建指定尺寸的稀疏数组
        int[][] retArr = new int[sum + 1][3];
        // 3. 初始化稀疏数组表头 : 行、列、值的个数
        retArr[0][0] = arr.length;
        retArr[0][1] = arr[0].length;
        retArr[0][2] = sum;
        int count = 1; // 一个临时标记为，用于记录统计到第几个数字了
        // 4. 填充剩余的部分
        for(int a = 0; a < arr.length; a ++) {
            for (int b = 0; b < arr[a].length; b++) {
                if (arr[a][b] != 0) {
                    retArr[count][0] = a;
                    retArr[count][1] = b;
                    retArr[count][2] = arr[a][b];
                    count ++;
                }
            }
        }
        Utils.print2DArr(retArr);
    }

    /**
     *  稀疏数组转化成二维数组的过程
     */
    @Test
    public void sparseArr2Arr() {
        int arr[][] = createSparseArr();
        int[][] retArr = new int[arr[0][0]][arr[0][1]];
        for (int a = 1; a < arr.length; a ++) {
           retArr[arr[a][0]][arr[a][1]] = arr[a][2];
        }
        Utils.print2DArr(retArr);
    }
}
