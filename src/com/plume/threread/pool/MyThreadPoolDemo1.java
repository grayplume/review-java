package com.plume.threread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo1 {
    public static void main(String[] args) {
        //newCachedThreadPool  没有上限的线程池
        //newFixedThreadPool   有上限

        //1.获取线程池对象
        // ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        //2.提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        //3.销毁线程池
        // pool1.shutdown();
    }
}
