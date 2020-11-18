package com.lizza.ThreadCommunication;

/**
 * 题目: 4个线程，交替打印A、B、C，循环10次; 使用等待通知机制实现
 *
 * 思路: 使用wait/notify + 状态量实现
 */
public class WaitNotify_1 {

    private String flag = "A";

    private void printA() {
        synchronized (this) {
            while (flag != "A") {
                try { this.wait(); } catch (Exception e) {}
            }
            System.out.println(Thread.currentThread().getName() + ": A");
            this.flag = "B";
            this.notifyAll();
        }
    }

    private void printB() {
        synchronized (this) {
            while (flag != "B") {
                try { this.wait(); } catch (Exception e) {}
            }
            System.out.println(Thread.currentThread().getName() + ": B");
            this.flag = "C";
            this.notifyAll();
        }
    }

    private void printC() {
        synchronized (this) {
            while (flag != "C") {
                try { this.wait(); } catch (Exception e) {}
            }
            System.out.println(Thread.currentThread().getName() + ": C");
            this.flag = "A";
            this.notifyAll();
        }
    }

    public static void main(String[] args){
        WaitNotify_1 object = new WaitNotify_1();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                object.printA();
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                object.printB();
            }
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                object.printC();
            }
        }, "t3").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                object.printB();
            }
        }, "t4").start();
    }

}
