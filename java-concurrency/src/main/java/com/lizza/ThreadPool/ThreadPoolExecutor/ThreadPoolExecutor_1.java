package com.lizza.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-04
 */
public class ThreadPoolExecutor_1 {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                19, 32, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i = 0; i < 100; i++){
            int index = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + index);
            });
        }
        executor.shutdown();
    }
}
