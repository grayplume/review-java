package com.plume.threread.impl1;

public class MyThread extends Thread{

    @Override
    public void run() {
        //要执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"Hello World");
        }
    }
}
