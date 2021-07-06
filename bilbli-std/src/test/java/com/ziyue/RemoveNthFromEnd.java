package com.ziyue;

import lombok.Data;
import org.junit.Test;

public class RemoveNthFromEnd {


    @Data
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    @Test
    public void doTest() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node ret = solution(node1, 1);
        while (null != ret) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public Node solution(Node node, int n) {
        int cout = 1;
        Node head = node; //  临时记录head
        Node pre = null;  // 记录删除节点的前一个节点
        Node tmp = node;  // 记录要删除的节点
        while (null != node && null != node.next) {
            if (cout >= n) {
                pre = tmp;
                tmp= tmp.next;
            }
            node = node.next;
            cout ++;
        }
        Node nextNode = tmp.next;  // 节点替换
        if (null != pre) {
            pre.next = nextNode;
            return head;
        }
        return head.next; // 删除节点的前一个节点， 那就是要删除头节点
    }
}
