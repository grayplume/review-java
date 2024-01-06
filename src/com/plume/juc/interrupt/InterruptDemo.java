package com.plume.juc.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class InterruptDemo {
    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"\t isInterrupted修改为true");
                    break;
                }
                System.out.println("t1 ----hello isInterrupted");
            }
        },"t1");
        t1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(t1::interrupt,"t2").start();
    }

    private static void m2_atomicBoolean() {
        new Thread(()->{
            while (true){
                if (atomicBoolean.get()){
                    System.out.println(Thread.currentThread().getName()+"\t atomicBoolean的值修改为True");
                    break;
                }
                System.out.println("t1 ----hello atomicBoolean");
            }
        },"t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            atomicBoolean.set(true);
        },"t2").start();
    }

    private static void m1_volatile() {
        new Thread(()->{
            while (true){
                if (isStop){
                    System.out.println(Thread.currentThread().getName()+"\t isStop的值修改为True");
                    break;
                }
                System.out.println("t1 ----hello volatile");
            }
        },"t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            isStop = true;
        },"t2").start();
    }
}
