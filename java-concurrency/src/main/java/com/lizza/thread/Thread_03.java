package com.lizza.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 利用Future和Callable创建带返回值的线程
 */
public class Thread_03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " Is Running!");
            return 10;
        });
        new Thread(task).start();
        System.out.println("Result Is: " + task.get());
    }
}
