package com.lizza.util;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 闭锁
 * 1. 问题描述
 *      多个线程同时执行任务, 主线程必须等待所有线程执行完毕后再结束
 * 2. 解决方案
 *      CountDownLatch
 * 3. 实现原理
 *      1. CountDownLatch主要有两个方法, 当一个或多个线程调用await方法时, 这些线程会阻塞
 *      2. 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)
 *      3. 当计数器的值变为0时, 因await方法阻塞的线程会被唤醒, 继续执行
 */
public class CountDownLatch_1 {

    public static void main(String[] args) throws InterruptedException {
//        errorDemo();
        countDownLatch();
    }

    public static void countDownLatch() throws InterruptedException {
        CountDownLatch counter = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Execute The Task!");
                counter.countDown();
            }, String.valueOf(i)).start();
        }
        counter.await();
        System.out.println(Thread.currentThread().getName() + " Finished!");

    }

    public static void errorDemo() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Execute The Task!");
            }, String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName() + " Finished!");
    }
}
