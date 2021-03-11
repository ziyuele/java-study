package com.ziyue;


/**
 *  数组模拟环形队列的实现
 */
public class CircleQueueTest {

    class CircleQueue {
        private int rear;
        private int front;
        private int[] arr;
        private int maxSize;

        public CircleQueue(int maxSize) {
            this.maxSize = maxSize;
            this.rear = 0;
            this.front = 0;
            this.arr = new int[maxSize];
        }

        // TODO-kj
        public boolean isEmpty() {
           return false;
        }

        // TODO-kj
        public boolean isFull() {
           return false;
        }

        public void addQueue() {

        }

        public int getQueue() {
           return -1;
        }

        public int getFirst() {
           return -1;
        }
    }
}
