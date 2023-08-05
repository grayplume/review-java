package com.plume.threread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {
    public static void main(String[] args) {
        // 自定义线程池
        /*  corePoolSize：   核心线程的最大值，不能小于0
            maximumPoolSize：最大线程数，不能小于等于0，maximumPoolSize >= corePoolSize
            keepAliveTime：  空闲线程最大存活时间,不能小于0
            unit：           时间单位
            workQueue：      任务队列，不能为null
            threadFactory：  创建线程工厂,不能为null
            handler：        任务的拒绝策略,不能为null  */
        new ThreadPoolExecutor(
                3,
                6,
                60,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


    }
}
