package com.lizza.ThreadPool.newScheduledThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-10-10
 */
public class NewScheduledThreadPool {

    public static void main(String[] args){
        System.out.println("now date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(() -> {
            System.out.println("now date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }, 3, 3, TimeUnit.SECONDS);
    }
}
