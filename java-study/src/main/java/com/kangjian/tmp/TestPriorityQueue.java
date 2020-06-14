/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String args[]) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(5);
        priorityQueue.add(-3);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
    }
}
