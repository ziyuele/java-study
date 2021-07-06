package com.ziyue;

import lombok.Data;
import org.junit.Test;

import java.util.List;

public class SwapPairs {

    @Data
    class Node {
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node res = solution(node1);
        while (res != null) {
            System.out.print(res.val + "\t");
            res = res.next;
        }
        System.out.println();
    }

    public Node solution(Node node) {
        Node ret;
        if (null != node && null != node.next) {
            ret = node.next;
        } else {
            ret = node;
        }
        Node preNode = null;
        while (null != node && null != node.next) {

            Node head = node;
            Node end = node.next;
            head.next = end.next;
            end.next = head;
            node = head.next;
            if (null != preNode) {
                preNode.next = end;
            }
            preNode = head;
        }
        return ret;
    }
}
