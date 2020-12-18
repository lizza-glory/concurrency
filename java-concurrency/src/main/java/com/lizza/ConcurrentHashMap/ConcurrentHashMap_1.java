package com.lizza.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 源码学习
 *
 */
public class ConcurrentHashMap_1 {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
		// put 方法
		map.put("name", "张三");
	}
}
