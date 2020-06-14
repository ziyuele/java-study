/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.HashSet;

public class ListHasCycleTest {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{"
                    + "val=" + val
                    + ", next=" + next
                    + '}';
        }
    }

    public static ListNode initList() {
        /**
         *  3 -> 2 -> 0 -> -4
         *       |          |
         *       +----------+
         */
        ListNode head;
        ListNode cycleNode;
        ListNode nextNode;
        head = new ListNode(3);
        head.next = new ListNode(2);
        cycleNode = head.next;
        nextNode = head.next;
        nextNode.next = new ListNode(0);
        nextNode = nextNode.next;
        nextNode.next = new ListNode(-4);
        nextNode = nextNode.next;
        nextNode.next = cycleNode;
        return head;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode qickPoint = head;
        ListNode slowPoint = head;
        while ( qickPoint != null && qickPoint.next != null ) {
            slowPoint = slowPoint.next;
            qickPoint = qickPoint.next.next;
            if (qickPoint != null && qickPoint.val == slowPoint.val) {
                System.out.println(qickPoint.val);
                return true;
            }
        }
        return false;

    }

    public static boolean hasCycleHash(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode node = head;
        while ( node != null ) {
            if (hashSet.contains(node)) {
                System.out.println(node.val);
                return true;
            } else {
                hashSet.add(node);
            }
            node = node.next;
        }
        return false;

    }

    public static void main(String args[]) {
        //System.out.println(hasCycle(initList()));
        System.out.println(hasCycleHash(initList()));
    }

}
