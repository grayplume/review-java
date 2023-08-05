package com.plume.threread.method;

public class ThreadDemo2 {
    public static void main(String[] args) {
        /*
        * setPriority 优先级
        * getPriority
        * */

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "AAA");
        Thread t2 = new Thread(mr, "BBB");

        System.out.println(t1.getPriority());//默认为5
        System.out.println(t2.getPriority());

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();

    }
}
