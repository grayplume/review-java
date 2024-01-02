package com.plume.juc;

import java.util.concurrent.*;

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3个任务  开启多个异步线程  耗时多少

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });
        threadPool.submit(futureTask1);
        FutureTask<String> futureTask2 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(300);
            return "task2 over";
        });
        threadPool.submit(futureTask2);

        FutureTask<String> futureTask3 = new FutureTask<String>(()->{
            TimeUnit.MILLISECONDS.sleep(300);
            return "task3 over";
        });
        threadPool.submit(futureTask3);

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        long endTime = System.currentTimeMillis();
        System.out.println("----costTime"+(endTime - startTime)+" 毫秒");
        System.out.println(Thread.currentThread().getName()+"\t ----end");
        threadPool.shutdown();

    }

    private static void m1() {
        // 3个任务  main线程  耗时多少
        long startTime = System.currentTimeMillis();
        // 暂停毫秒
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("----costTime"+(endTime - startTime)+" 毫秒");
        System.out.println(Thread.currentThread().getName()+"\t ----end");
    }
}
