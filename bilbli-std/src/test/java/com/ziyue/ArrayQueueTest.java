package com.ziyue;

import org.junit.Test;

public class ArrayQueueTest {

    @Test
    public void testQueue() {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getFirst());
    }

    class ArrayQueue {
        private int maxSize;
        private int font;
        private int rear;
        private int[] arr;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[maxSize];
            this.rear = -1;
            this.font = -1;
        }

        // 1. 判断队列是否满
        public boolean isFull() {
            return  rear + 1 == maxSize;
        }

        // 2. 判断对列是否为空
        public boolean isEmpty() {
            return  rear == font;
        }

        // 3. 入队
        public void addQueue(int num) {
            if (isFull()) {
                throw new RuntimeException("Queue is full");
            }
            rear ++;
            arr[rear] = num;
        }

        // 4. 出队
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("No element exist");
            }
            font ++;
            return arr[font];
        }

        // 5. 获取队列头部元素, 单不出队
        public int getFirst() {
            if (isEmpty()) {
                throw new RuntimeException("No element exist");
            }
            return arr[font + 1];
        }
    }

}
