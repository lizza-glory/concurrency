package com.lizza.base;

/**
 * 死锁演示
 * 两个线程都持有对方线程所有需要的资源的锁
 */
public class DeadLock_01 {

    public static void main(String[] args){
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            // ① 线程t1持有a的锁
            synchronized (a) {
                System.out.println("t1持有了a的锁");
                try {
                    // ② 线程t1休眠5ms, cpu切换到线程t2
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // ⑤ 线程t1尝试获取b的锁, 但是t2没有释放, 所以t1阻塞等待锁的释放
                synchronized (b) {
                    System.out.println("t1持有了b的锁");
                }
            }
        }, "t1").start();

        new Thread(() -> {
            // ③ 线程t2持有b的锁
            synchronized (b) {
                System.out.println("t2持有了b的锁");
                try {
                    // ④ 线程t2休眠5ms, cpu切换到线程t1
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // ⑥ 线程t2尝试获取a的锁, 但是t1没有释放, 所以t2阻塞等待锁的释放
                synchronized (a) {
                    System.out.println("t2持有了a的锁");
                }
            }
        }, "t2").start();
    }
}
