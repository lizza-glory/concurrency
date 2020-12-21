package com.lizza.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-12-20
 */
public class ReentrantLock_1 {

    private final static Lock lock = new ReentrantLock(true);

    public static void main(String[] args){
        lock.lock();
    	try {
    	    System.out.println("ReentrantLock");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	} finally {
    	    lock.unlock();
    	}
    }
}
