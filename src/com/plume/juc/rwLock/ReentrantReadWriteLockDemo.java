package com.plume.juc.rwLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyResource{
    Map<String,String> map = new HashMap<>();
    // ReentrantLock等价于synchronized
    Lock lock = new ReentrantLock();
    // ReentrantReadWriteLock 一体两面 读写互斥 读读共享
    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void write(String key,String value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入...");
            map.put(key, value);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 完成写入...");
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void read(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读...");
            String result = map.get(key);
            // try {
            //     TimeUnit.MILLISECONDS.sleep(200);
            // } catch (InterruptedException e) {
            //     throw new RuntimeException(e);
            // }

            // 读锁没有完成前写锁无法进行
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 完成读取:"+result);
        } finally {
            rwLock.readLock().unlock();
        }
    }

}

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 0; i <10; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.write(finalI+"",finalI+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i <10; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.read(finalI+"");
            },String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i <3; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.write(finalI+"",finalI+"");
            },"新写锁线程"+String.valueOf(i)).start();
        }
    }
}
