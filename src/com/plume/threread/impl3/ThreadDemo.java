package com.plume.threread.impl3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        * 创建一个Callable实现Callable接口
        * 重写call
        * */
        //创建MyCallable的对象--表示多线程要执行的任务
        MyCallable mc = new MyCallable();
        //创建FutureTask对象--管理多线程运行的结果
        FutureTask<Integer> ft = new FutureTask<>(mc);
        //创建线程对象
        Thread t1 = new Thread(ft);
        //启动
        t1.start();

        //获取多线程运行的结果
        Integer result = ft.get();
        System.out.println(result);
    }
}
