package com.ziyue;


import org.junit.Test;

import java.util.Arrays;

/**
 * 数组模拟环形队列的实现
 */
public class CircleQueueTest {

    @Test
    public void testCircleQueue() {
        CircleQueue circleQueue = new CircleQueue(3);
        circleQueue.addQueue(1);
        circleQueue.addQueue(2);
        System.out.println("size=" + circleQueue.size());
        circleQueue.addQueue(3);

        System.out.println("size=" + circleQueue.getQueue());
        circleQueue.addQueue(4);
        System.out.println(circleQueue.size());
        System.out.println(circleQueue.getQueue());
        System.out.println("dataList is: " + circleQueue.getUsageString());
        System.out.println(circleQueue.getQueue());
        System.out.println(circleQueue.getQueue());
        System.out.println("size=" + circleQueue.size());
    }

    static class CircleQueue {
        private int rear;
        private int front;
        private int[] arr;
        private int size;

        public CircleQueue(int maxSize) {
            // 预留一个空间作为约定
            this.size = maxSize + 1;
            this.rear = 0;
            this.front = 0;
            this.arr = new int[size];
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void addQueue(int num) {
            if (isFull()) {
                throw new RuntimeException("Queue is full, add failed num=" + num);
            }
            arr[rear] = num;
            rear = (rear + 1) % size;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            int ret = arr[front];
            front = (front + 1) % size;
            return ret;
        }

        public int getFirst() {
            return arr[front];
        }

        public int size() {
            return (rear + size - front) % size;
        }

        public String toString() {
            return Arrays.toString(arr);
        }

        public String getUsageString() {
            StringBuilder stringBuffer = new StringBuilder();
            int start = front;
            int end = rear;
            while (start != end) {
                stringBuffer.append(arr[start]).append(" ");
                start = (start + 1) % size;
            }
            return stringBuffer.toString();
        }
    }
}
