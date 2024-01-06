package com.plume.juc.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+
                            "\t 中断标志位:"+Thread.currentThread().isInterrupted() +
                            " 程序停止");
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //中断状态会被清除,要再次设置
                    // throw new RuntimeException(e);
                    e.printStackTrace();
                }
                System.out.println("----hello InterruptDemo3");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(t1::interrupt,"t2").start();
    }
}
