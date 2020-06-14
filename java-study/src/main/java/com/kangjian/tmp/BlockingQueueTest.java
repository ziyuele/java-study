/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

    public BlockingQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public static void main(String args[]) {
        BlockingQueueTest test = new BlockingQueueTest();
        BlockingQueue queue = test.getQueue();
        while(queue.offer("hh" + System.currentTimeMillis())){

        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
