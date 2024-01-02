package com.plume.juc;

import java.util.concurrent.*;

public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(()->{
                System.out.println(Thread.currentThread().getName() + "----come in");
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("---1秒后出结果:" + result);
                if (result > 5){
                    int i = 10 / 0;
                }
                return result;
            },threadPool).whenComplete((v,e)->{
                if (e == null){
                    System.out.println("----计算完成,更新系统:"+v);
                }
            }).exceptionally(e->{
                e.printStackTrace();
                System.out.println("异常信息:"+e.getCause()+"\t"+e.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName()+"线程先去忙别的任务");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }

        // 主线程不要立即结束否则CompletableFuture默认使用的线程池会立刻关闭
        // 使用自定义线程池解决
        // TimeUnit.SECONDS.sleep(3);

    }

    private static void future1() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("---1秒后出结果:" + result);
            return result;
        });

        System.out.println(Thread.currentThread().getName()+"线程先去忙别的任务");
        System.out.println(completableFuture.get());
    }
}
