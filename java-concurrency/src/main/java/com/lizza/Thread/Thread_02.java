package com.lizza.Thread;

public class Thread_02 {

    public static void main(String[] args){
        new Thread(new MyThread2()).start();
    }
}

class MyThread2 implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Is Running!");
    }
}