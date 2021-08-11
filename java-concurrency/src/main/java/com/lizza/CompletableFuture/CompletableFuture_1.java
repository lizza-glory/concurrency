package com.lizza.CompletableFuture;

import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @Desc:
 * 参考:  https://www.jianshu.com/p/744856fc098f
 * @author: lizza.liu
 * @date: 2021-08-06
 */
public class CompletableFuture_1 {

    public static void main(String[] args) {
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            int result = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                if (result % 2 != 0) {
                    try {
                        Thread.sleep(550);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return result;
            });
            future.obtrudeValue(-1);
            futureList.add(future);
        }
        for (CompletableFuture<Integer> future : futureList) {
            try {
                System.out.println(future.get(200, TimeUnit.MILLISECONDS));
                future.whenComplete((integer, throwable) -> System.out.println("\t123" + integer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
