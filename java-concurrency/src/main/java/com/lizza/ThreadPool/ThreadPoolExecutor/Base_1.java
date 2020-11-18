package com.lizza.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-09-25
 */

public class Base_1 {

    public static void main(String[] args){
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        for (int i = 0; i < 100; i++) {
            queue.add("No."+i);
        }
        System.out.println(queue);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i = 0; i < 100; i++){
            executor.execute(() -> {
                System.out.println("["+Thread.currentThread().getName()+"]"+queue.poll());
            });
        }
        executor.shutdown();
    }
}
