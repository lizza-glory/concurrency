package com.lizza.ParallelCompute.allOf_3;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Computer_1 {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future_1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }, executorService);
        CompletableFuture<Integer> future_2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }, executorService);
//        CompletableFuture.allOf(future_1, future_2);
        System.out.println(future_1.get());
        System.out.println(future_2.get());
        executorService.shutdown();
    }
}
