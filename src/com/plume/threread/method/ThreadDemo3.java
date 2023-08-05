package com.plume.threread.method;

public class ThreadDemo3 {
    public static void main(String[] args) {
        /*
         * setDaemon  设置为守护线程
         * */

        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }



}
