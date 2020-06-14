/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class TestCode {
    public static void main(String args[]) {
        List<Integer> list  = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        doWork(list, 2);
    }

    public static void doWork(List<Integer> list, int k) {
        int tmp = k;
        Stack<Integer> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>(list.size());
        for (Integer x : list) {
            if (tmp > 0) {
                stack.push(x);
                tmp --;
                continue;
            } else {
                while(!stack.empty()) {
                    ret.add(stack.pop());
                }
                stack.push(x);
                tmp = k -1 ;
            }
        }
        while(!stack.empty()) {
            ret.add(stack.pop());
        }
        System.out.println(ret.toString());
    }
}
