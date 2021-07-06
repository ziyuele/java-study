package com.ziyue;

import lombok.Data;
import org.junit.Test;

import java.util.Stack;

public class TreeTest {

    @Data
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode buildTreeNode() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode6;

        treeNode4.right = treeNode8;

        return treeNode1;
    }

    @Test
    public void doTest() {
        printTreeNodeA(buildTreeNode());
        System.out.println();
        printTreeNodeB(buildTreeNode());
        System.out.println();
        printTreeNodeC(buildTreeNode());
        System.out.println();
        //printTreeNodeD(buildTreeNode());
        System.out.println();
        printTreeNodeE(buildTreeNode());
        System.out.println();
        printTreeNodeF(buildTreeNode());

    }

    /**
     *  递归遍历节点， 前序遍历
     * @param treeNode
     */
    public void printTreeNodeA(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        System.out.print(treeNode.val + "\t");
        printTreeNodeA(treeNode.left);
        printTreeNodeA(treeNode.right);
    }


    /**
     *  递归遍历节点， 中序遍历
     * @param treeNode
     */
    public void printTreeNodeB(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        printTreeNodeB(treeNode.left);
        System.out.print(treeNode.val + "\t");
        printTreeNodeB(treeNode.right);
    }



    /**
     *  递归遍历节点， 后序遍历
     * @param treeNode
     */
    public void printTreeNodeC(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        printTreeNodeC(treeNode.left);
        printTreeNodeC(treeNode.right);
        System.out.print(treeNode.val + "\t");
    }


    /**
     *  非递归遍历节点， 基于栈实现
     * @param treeNode
     */
    public void printTreeNodeD(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + "\t");
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 非递归遍历节点， 前序遍历，先打印，再输出
     * @param treeNode
     */
    public void printTreeNodeE(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = treeNode;
        while (null != curNode || !stack.isEmpty()) {
            if (null != curNode) {
                System.out.print(curNode.val + "\t");
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (curNode == null) {
                curNode = stack.pop().right;
            }
        }
    }

    /**
     * 非递归遍历节点， 中序遍历, 先压栈
     * @param treeNode
     */
    public void printTreeNodeF(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = treeNode;
        while (null != curNode || !stack.isEmpty()) {
            if (null != curNode) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (curNode == null) {
                curNode = stack.pop();
                System.out.print(curNode.val + "\t");
                curNode = curNode.right;
            }
        }
    }


}
