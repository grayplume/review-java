package com.plume.threread.method;

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        /*getName
        * setName
        *   如果没有设置，默认Thread-X,重写构造方法空参和name可直接传如线程名
        * currentThread
        *   当jvm虚拟机启动后会启动多条线程,其中一条就叫做main线程
        *   作用就是调用main方法执行里面的代码
        * sleep
        *   哪条线程执行到此,就会停留对应的时间,单位毫秒
        *   时间结束后会继续 执行后面的代码
        * */

        /*//1.创建线程对象
        MyThread t1 = new MyThread("灰羽");
        MyThread t2 = new MyThread("大炮");

        //2.开启线程
        t1.start();
        t2.start();*/

        //哪条线程执行到这个方法，此时获取的就是哪条线程的对象
        /*Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println(name);*/

        System.out.println("1111111");
        Thread.sleep(5000);
        System.out.println("2222222");


    }
}
