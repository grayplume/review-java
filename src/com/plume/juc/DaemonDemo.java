package com.plume.juc;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 开始运行，"+
                    (Thread.currentThread().isDaemon()?"守护线程":"用户线程"));
            while (true){

            }
        },"t1");
        // 默认为用户线程，main线程结束t1不会结束，设置为守护线程后，main线程结束t1会伴随结束
        // This method must be invoked before the thread is started.
        t1.setDaemon(true);
        t1.start();

        // 暂停几秒线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+"\t ---end 主线程");

    }
}
