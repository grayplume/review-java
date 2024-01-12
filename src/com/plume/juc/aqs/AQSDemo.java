package com.plume.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(); // 非公平锁

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("----come in A");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                reentrantLock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("----come in C");
            } finally {
                reentrantLock.unlock();
            }
        }, "C").start();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("----come in D");
            } finally {
                reentrantLock.unlock();
            }
        }, "D").start();


    }
}
