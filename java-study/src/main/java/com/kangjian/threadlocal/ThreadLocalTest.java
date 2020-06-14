package com.kangjian.threadlocal;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class ThreadLocalTest {
    public static void main(String[] args) throws Exception {
        CountDownLatch     countDownLatch  = new CountDownLatch(10);
        CyclicBarrier      cyclicBarrier   = new CyclicBarrier(10);
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        executorService.execute(new Executable(countDownLatch, cyclicBarrier));
        Thread.sleep(10000);
        System.exit(0);
    }

    private static class Executable implements Runnable {
        private final CountDownLatch countDownLatch;
        private final CyclicBarrier  cyclicBarrier;

        public Executable(CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier) {
            this.countDownLatch = countDownLatch;
            this.cyclicBarrier  = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(cyclicBarrier.getNumberWaiting());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            MyExecutor executor = new MyExecutor();
            executor.doSomeThing();
            executor.getSomeThing();
        }
    }
}
