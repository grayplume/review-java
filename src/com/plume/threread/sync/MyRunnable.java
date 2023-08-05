package com.plume.threread.sync;

public class MyRunnable implements Runnable {

    int ticket = 0;

    @Override
    public void run() {
        // 1.循环
        while (true) {
            // 2.同步代码块/同步方法
            if (method()) break;
        }
    }

    //this
    private synchronized boolean method() {
        // 3.判断共享数据是否到末尾
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() +
                    "在卖第" + ticket + "张票");
        }
        return false;
    }
}
