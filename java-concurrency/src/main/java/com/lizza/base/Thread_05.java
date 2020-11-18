package com.lizza.base;

/**
 * wait()方法：阻塞当前线程
 * @author lt
 * @date 2019年5月9日
 * @version v1.0
 */
public class Thread_05 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start...");
				try {
					synchronized (this) {
						System.out.println(Thread.currentThread().getName());
						this.wait(0);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end...");
			}
		}).start();
	}
}
