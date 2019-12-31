/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {

    }
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree_bfs(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode treeNode = node.left;
            node.left = node.right;
            node.right = treeNode;
            if (null != node.right) {
               queue.offer(node.right);
            }
            if (null != node.left) {
               queue.offer(node.left);
            }
        }
        return root;
    }
}
