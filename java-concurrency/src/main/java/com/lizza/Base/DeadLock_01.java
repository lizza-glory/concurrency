package com.lizza.Base;

/**
 * 死锁演示
 * 两个线程都持有对方线程所有需要的资源的锁
 *
 * jstack工具
 * jstack是java虚拟机自带的一种堆栈跟踪工具
 * jstack用于打印出给定的java进程ID或corefile或远程调试服务的Java堆栈信息
 * 如果是在64位机器上，需要指定选项"-J-d64"，Windows的jstack使用方式只支持以下的这种方式：jstack[-l]pid
 * 主要分为两个功能：
 * a．针对活着的进程做本地的或远程的线程dump；
 * b．针对core文件做线程dump。
 *
 * 下面使用“死锁”来查看Java堆栈信息
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
