/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class KthSmallest {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int tmp = 0;
    int ret = 0;
    int num;

    public void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right );
        }
        tmp ++;
        if (tmp == num) {
            ret = root.val;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return ret;
    }

    public static void main(String args[]) {

    }
}
