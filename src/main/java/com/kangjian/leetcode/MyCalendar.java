/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

import java.util.TreeMap;

/**
 * set at @https://leetcode-cn.com/problems/my-calendar-i/
 */
public class MyCalendar {

    static TreeMap<Integer, Integer> cleader = new TreeMap<>();

    private MyCalendar() {

    }


    public boolean book(int start, int end) {
        Integer startValue = cleader.floorKey(start);
        Integer endValue = cleader.ceilingKey(start);
        // 检查上一个日程的结束时间是否和当前日程开始时间冲突 结束时间必须小于开始时间
        if (startValue != null && cleader.get(startValue) > start)  {
            return false;
        }
        // 检查下一个日程的开始时间是否和当前日程的结束时间冲突
        if (endValue != null && endValue < end) {
           return false;
        }

        cleader.put(start, end);
        return true;
    }
    public static void main(String args[]) {
    }
}
