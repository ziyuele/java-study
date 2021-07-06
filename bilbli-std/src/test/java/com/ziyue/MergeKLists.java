package com.ziyue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class MergeKLists {
    /**
     * 合并N个有序列表
     */
    @Data
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    @Test
    public void doTest() {
        Node nodeA1 = new Node(1);
        Node nodeA2 = new Node(4);
        Node nodeA3 = new Node(5);
        nodeA1.next=nodeA2; nodeA2.next=nodeA3;

        Node nodeB1 = new Node(1);
        Node nodeB2 = new Node(3);
        Node nodeB3 = new Node(4);
        nodeB1.next = nodeB2; nodeB2.next=nodeB3;

        Node nodeC1 = new Node(2);
        Node nodeC2 = new Node(6);
        nodeC1.next=nodeC2;

        Node[] nodes = new Node[3];
        nodes[0] = nodeA1;
        nodes[1] = nodeB1;
        nodes[2] = nodeC1;

        Node ret = solution(nodes);
        while (null != ret) {
            System.out.print(ret.val + "\t");
            ret = ret.next;
        }
        System.out.println();
    }

    public Node solution(Node[] req) {
        if (req.length < 1) {
            return null;
        }
        if (req.length ==1) {
            return req[0];
        }
        Node head = req[0];
        for (int a = 1; a < req.length; a ++ ) {
            head = mergeList(head, req[a]);
        }
        return head;
    }

    // 合并两个有序列表， 递归
    public Node mergeList(Node nodeA, Node nodeB) {
        if (null == nodeA) {
            return  nodeB;
        }
        if (null == nodeB) {
            return nodeA;
        }
        if (nodeA.val < nodeB.val) {
            nodeA.next =  mergeList(nodeA.next, nodeB);
            return nodeA;
        } else {
            nodeB.next = mergeList(nodeA, nodeB.next);
            return nodeB;
        }
    }
}
