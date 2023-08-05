package com.plume.threread.deadlock;

public class MyThread extends Thread{
    static Object objA = new Object();
    static Object objB = new Object();

    @Override
    public void run() {
        while(true){
            if ("线程A".equals(getName())){
                synchronized (objA){
                    System.out.println("线程A拿了A锁，准备拿B锁");
                    synchronized (objB){
                        System.out.println("线程A拿了B锁，顺利执行完一轮");
                    }
                }
            }else if ("线程B".equals(getName())){
                synchronized (objB){
                    System.out.println("线程B拿了B锁，准备拿A锁");
                    synchronized (objA){
                        System.out.println("线程B拿了A锁，顺利执行完一轮");
                    }
                }
            }
        }
    }
}
