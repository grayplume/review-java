package com.plume.threread.impl2;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        实现多线程方式二：实现Runnable接口
        * */
        //创建MyRun对象
        MyRun mr = new MyRun();
        //创建线程对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        //设置线程名称
        t1.setName("线程1");
        t2.setName("线程2");

        //开启线程
        t1.start();
        t2.start();

        //因为Runnable是函数式接口可以这么写

        new Thread(()->{
            System.out.println(Thread.currentThread()+"java8 匿名内部类");
        }).start();


    }
}
