/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class IsSameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checktree(TreeNode p, TreeNode q) {
        if (!check(p, q)) {
            return false;
        }
        if (p == null) {
            return true;
        }
        return checktree(p.left, q.left) && checktree(p.right, q.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p != null && q != null && p.val != q.val) {
            return false;
        }

        return true;

    }

    public static void main(String args[]) {

    }
}
