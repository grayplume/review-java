package com.plume.threread.impl1;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        实现多线程方式一：继承Thread类
        * */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        //设置线程名称
        t1.setName("线程1");
        t2.setName("线程2");

        //开启线程
        t1.start();
        t2.start();

    }
}
