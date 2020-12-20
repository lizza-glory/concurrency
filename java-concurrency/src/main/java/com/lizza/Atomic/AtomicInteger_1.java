package com.lizza.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 实现原子自增 计数器
 */
public class AtomicInteger_1 {

    public static void main(String[] args){
        AtomicInteger count = new AtomicInteger(0);
        while (count.get() < 20)
            System.out.println(count.getAndIncrement());
    }
}
