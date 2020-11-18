package com.lizza.Thread;

/**
 * 线程创建的四种方式
 * 1. 继承Thread类重写run方法
 * 2. 实现Runnable接口, 重写run方法
 * 3. 实现Callable接口, 重写call方法
 * 4. 线程池创建线程
 */
public class Thread_01 {

    public static void main(String[] args){
        MyThread1 myThread1 = new MyThread1();
        myThread1.run();
        myThread1.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Is Running!");
    }
}