package com.plume.threread.sync;

public class SellingTickets3 {
    public static void main(String[] args)  {
        //卖票
        //线程执行的随机性可能在卖票过程中丢失cpu的执行权,导致出现问题
        //synchronized解决
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        MyThread2 t3 = new MyThread2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
