/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
// see at : https://leetcode-cn.com/problems/top-k-frequent-elements/
public class TopKFrequent {
    public static void main(String args[]) {
        // int arr[] = {1, 1, 1, 2, 2, 3};
        int arr[] = {3,0,1,0};
        System.out.println(solution(arr, 2));
    }

    public static List<Integer> solution(int[] arr, int top) {
        Map<Integer, Integer> hashMap = new TreeMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> hashMap.get(b) - hashMap.get(a));
        for (int x : arr) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        for (int x : hashMap.keySet()) {
            priorityQueue.offer(x);
        }
        List<Integer> ret = new LinkedList<>();
        for (int x =0; x< top; x++) {
            ret.add(priorityQueue.poll());
        }
        return ret;
    }
}

