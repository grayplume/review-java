package com.plume.threread.impl2;

public class MyRun implements Runnable{

    @Override
    public void run() {
        //要执行的代码
        for (int i = 0; i < 100; i++) {
            //获取当前线程对象
            // Thread t = Thread.currentThread();
            System.out.println(Thread.currentThread().getName()+"Hello World");
        }
    }
}
