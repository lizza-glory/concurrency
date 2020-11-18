package com.lizza.base;

/**
 * wait()方法：
 * @author lt
 * @date 2019年5月9日
 * @version v1.0
 */
public class Thread_04 {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start...");
				try {
					this.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end...");
			}
		}).start();;
	}
}
