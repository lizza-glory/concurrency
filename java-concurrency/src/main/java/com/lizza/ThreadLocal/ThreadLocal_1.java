package com.lizza.ThreadLocal;

/**
 * @author lt
 * @date 2019年5月19日
 * @version v1.0
 */
public class ThreadLocal_1 {

	public static void main(String[] args) {
		ThreadLocal<String> name = new ThreadLocal<>();
		ThreadLocal<Integer> age = new ThreadLocal<>();
		Thread t1 = new Thread(() -> {
			name.set("李华");
			//只能获取当前线程set的值
			System.out.println(Thread.currentThread().getName() + ", name: " + name.get());
			//输出为null
			System.out.println(Thread.currentThread().getName() + ", age: " + age.get());
		}, "线程1");
		Thread t2 = new Thread(() -> {
			name.set("王五");
			age.set(23);
			//输出为null
			System.out.println(Thread.currentThread().getName() + ", name: " + name.get());
			//只能获取当前线程set的值
			System.out.println(Thread.currentThread().getName() + ", age: " + age.get());
		}, "线程2");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName() + ", name: " + name.get());
	}
}
