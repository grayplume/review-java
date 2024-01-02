package com.plume.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<String>(()->{
            System.out.println(Thread.currentThread().getName()+"\t ----come in");
            // 暂停几秒线程
            TimeUnit.SECONDS.sleep(5);
            return "task over";
        });
        Thread t1 = new Thread(futureTask,"t1");
        t1.start();

        System.out.println(Thread.currentThread().getName()+"\t --忙其他任务");

        // System.out.println(futureTask.get()); // 等到结果后才会离开,程序容易阻塞,一般放在程序后面
        // System.out.println(futureTask.get(2,TimeUnit.SECONDS)); // 过时不侯

        // 轮询方式会耗费无谓的CPU资源
        while (true){
            if (futureTask.isDone()){
                System.out.println(futureTask.get());
                break;
            }else {
                // 暂停
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("正在处理...");
            }
        }


    }
}
