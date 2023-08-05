package com.plume.threread.sync;

public class MyThread extends Thread{
    //static表示这个对象共享ticket数据
    static int ticket = 0;
    //锁对象一定要是唯一的
    // static Object obj =  new Object();
    @Override
    public void run() { //123
        while(true){
            synchronized (MyThread.class){
                if (ticket < 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName()+"正在卖第"+ ticket + "票");
                }else {
                    break;
                }
            }
        }
    }
}
