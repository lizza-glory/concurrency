package com.lizza.ThreadLocal;

/**
 * @author lt
 * @date 2019年5月19日
 * @version v1.0
 */
public class ThreadLocal_2 {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		// 父子线程值传递
		threadLocal.set("lizza");
		new Thread(() -> {
			System.out.println("子线程: " + threadLocal.get());
		}, "name").start();
		System.out.println("父线程" + threadLocal.get());
	}
}
