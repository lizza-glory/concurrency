package com.lizza.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池：ThreadPoolExecutor使用
 * @author lt
 * @date 2019年6月3日
 * @version v1.0
 */
public class ThreadPool_2 {

	public static void main(String[] args) {
		int corePoolSize = 5;
		int maximumPoolSize = 10;
		long keepAliveTime = 5;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				corePoolSize, 
				maximumPoolSize, 
				keepAliveTime, 
				unit, 
				workQueue);
		for(int i=1; i<=15; i++){
			Task task = new Task(i);
			executor.execute(task);
			System.out.println(
					"池中线程数："+executor.getPoolSize()+"，"+
					"队列中任务数："+executor.getQueue().size()+"，"+
					"已完成任务数："+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}

class Task implements Runnable {

	private int taskId;
	
	public Task(int taskId){
		this.taskId = taskId;
	}
	@Override
	public void run() {
		System.out.println("任务-"+taskId+"开始运行！");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\t任务-"+taskId+"运行完毕！");
	}
	
}
