package com.plume.threread.sync;

public class SellingTickets1 {
    public static void main(String[] args)  {
        //卖票
        //线程执行的随机性可能在卖票过程中丢失cpu的执行权,导致出现问题
        //synchronized解决
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
