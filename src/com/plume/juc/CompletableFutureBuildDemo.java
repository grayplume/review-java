package com.plume.juc;

import java.util.concurrent.*;

public class CompletableFutureBuildDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有指定线程池使用默认线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
        //     System.out.println(Thread.currentThread().getName());
        //     // 暂停几秒
        //     try {
        //         TimeUnit.SECONDS.sleep(1);
        //     } catch (InterruptedException e) {
        //         throw new RuntimeException(e);
        //     }
        // },threadPool);
        //
        // System.out.println(completableFuture.get());


        // 有返回值的
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            // 暂停几秒
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello supplyAsync";
        },threadPool);
        System.out.println(completableFuture.get());

        threadPool.shutdown();
    }
}
