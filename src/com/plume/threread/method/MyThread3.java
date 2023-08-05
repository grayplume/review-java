package com.plume.threread.method;

public class MyThread3 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"@"+i);
            //出让当前CPU的执行权
            Thread.yield();
        }
    }
}
