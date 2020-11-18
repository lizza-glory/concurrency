package com.lizza.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：基本示例
 * @author lt
 * @date 2019年6月3日
 * @version v1.0
 */
public class ThreadPool_1 {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for(int i=0; i<10; i++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"开始运行！");
				}
			}, "线程"+i);
			pool.execute(t);
		}
	}
}
