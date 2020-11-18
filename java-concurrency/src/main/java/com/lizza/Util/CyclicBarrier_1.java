package com.lizza.Util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 * 1. 问题描述
 *      10人开会, 必须等10人都到了才能开始
 * 2. 解决方式
 *      CyclicBarrier
 *
 */
public class CyclicBarrier_1 {

    public static void main(String[] args){
        CyclicBarrier barrier = new CyclicBarrier(10, () -> {System.out.println("Meeting Start!");});
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(() -> {
                 System.out.println("Participant " + temp + " Arrive!");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
