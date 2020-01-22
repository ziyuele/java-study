/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.tmp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String args[]) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        System.out.println(semaphore.availablePermits());
        semaphore.acquire();
        System.out.println(semaphore.availablePermits());
        semaphore.acquire();
        semaphore.acquire();
        System.out.println(semaphore.availablePermits());
        if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
            System.out.println("get more lock");
        } else  {
            System.out.println("can't get any lock");
        }
    }
}
