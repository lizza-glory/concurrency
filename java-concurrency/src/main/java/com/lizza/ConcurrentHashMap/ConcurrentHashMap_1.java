package com.lizza.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lt
 * @date 2019年5月27日
 * @version v1.0
 */
public class ConcurrentHashMap_1 {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
		map.put("name", "张三");
		map.put("age", 15);
		System.out.println(map);
		map.get("name");
	}
}
