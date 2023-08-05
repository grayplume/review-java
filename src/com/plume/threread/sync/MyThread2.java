package com.plume.threread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread2 extends Thread{
    static Lock lock= new ReentrantLock();
    //static表示这个对象共享ticket数据
    static int ticket = 0;
    //锁对象一定要是唯一的
    // static Object obj =  new Object();
    @Override
    public void run() { //123抢夺
        while(true){
            // synchronized (MyThread.class){
            lock.lock();
            try {
                if (ticket == 100){
                    break;
                }else {
                    Thread.sleep(100);
                    ticket++;
                    System.out.println(getName()+"正在卖第"+ ticket + "票");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

            // }
        }
    }
}
