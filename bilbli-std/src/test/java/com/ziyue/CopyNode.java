package com.ziyue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CopyNode {

    Map<Node, Node> sourceTargetMap = new HashMap<>();
    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;

        }
    }

    private Node initNode() {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node1.random = null;
        node2.random = node1;
        node3.random = null;
        return node1;
    }

    @Test
    public void doTest() {
       Node retNode = copyNode(initNode());
        while (Objects.nonNull(retNode)) {
            System.out.println("[" + retNode.val + "," + (Objects.isNull(retNode.random) ? "null" : retNode.random.val )+ "]");
            retNode = retNode.next;
        }
    }

    public Node copyNode(Node node) {
        if(null == node) {
            return null;
        }

        if (sourceTargetMap.containsKey(node)) {
            return sourceTargetMap.get(node);
        }
        Node retNode = new Node(node.val);
        sourceTargetMap.put(node, retNode);
        retNode.next = copyNode(node.next);
        retNode.random = copyNode(node.random);
        return retNode;
    }


}

