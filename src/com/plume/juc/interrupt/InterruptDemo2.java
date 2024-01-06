package com.plume.juc.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo2 {
    public static void main(String[] args) {
        // 实例方法仅仅是设置线程的中断状态为true,发起一个协商而不会立即停止线程.
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 300; i++) {
                System.out.println("----"+i);
            }
            System.out.println("t1中断标志:"+Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();

        System.out.println("t1线程的默认中断标志:"+t1.isInterrupted());

        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t1.interrupt();
        System.out.println("t1线程的interrupt后中断标志:"+t1.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("2s后中断标志:"+t1.isInterrupted());//false 不活动的线程不会产生任何影响
    }
}
