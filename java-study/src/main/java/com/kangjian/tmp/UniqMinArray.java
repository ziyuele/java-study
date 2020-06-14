/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UniqMinArray {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private ArrayList<Integer> arr = new ArrayList<>();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void insert(int a) {
        try {
            writeLock.lock();
            arr.add(a);
        } finally {
            writeLock.unlock();
        }
    }

    public int uniqMin() {
        try {
            readLock.lock();
            HashMap<Integer, Integer> hashMap = new HashMap();
            int minValue = -1;
            for (int a : arr) {
                hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == 1) {
                    if (minValue == -1) {
                        minValue = entry.getKey();
                    } else {
                        minValue = minValue > entry.getKey() ? entry.getKey() : minValue;
                    }
                }
            }
            return minValue;
        } finally {
            readLock.unlock();
        }
    }
}
