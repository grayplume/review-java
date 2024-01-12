package com.plume.juc.rwLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static int number = 37;
    static StampedLock stampedLock = new StampedLock();

    public void write() {
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName() + "\t 写线程准备修改");
        try {
            number = number + 13;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName() + "\t 写线程修改结束");
    }

    // 悲观读,读没有完成时写锁无法获得
    public void read() {
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName() + "\t come in readLock 4 second..");
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "\t reading..");
        }
        try {
            int result = number;
            System.out.println(Thread.currentThread().getName() + "\t 获得成员变量值:" + result);
            System.out.println("写线程没有修改成功,读锁时无法介入,传统的读写互斥");
        } finally {
            stampedLock.unlockRead(stamp);
        }

    }

    // 乐观读,读没有完成时写锁允许获得
    public void tryOptimisticRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int result = number;
        // 故意间隔4s,乐观认为读取中没有其他线程修改过number值
        // System.out.println(Thread.currentThread().getName()+"\t come in readLock 4 second..");
        System.out.println("4秒前stampedLock.validate方法值（true无修改，false有修改）" + "\t" + stampedLock.validate(stamp));
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 正在读取 "+i+" 秒后"+
                    "stampedLock.validate方法值（true无修改，false有修改）"+"\t"+stampedLock.validate(stamp));
        }
        if (!stampedLock.validate(stamp)){
            System.out.println(Thread.currentThread().getName()+"\t"+"有人修改");
            stamp = stampedLock.readLock();
            try {
                System.out.println("从乐观读升级到悲观读");
                result = number;
                System.out.println("重新悲观读后result:"+result);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"finally value:"+result);
    }

    public static void main(String[] args) {
        StampedLockDemo resource = new StampedLockDemo();

        // new Thread(() -> {
        //     resource.read();
        // }, "readThread").start();
        // try {
        //     TimeUnit.SECONDS.sleep(4);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        // new Thread(() -> {
        //     System.out.println(Thread.currentThread().getName() + "\t ----come in");
        //     resource.write();
        // }, "writeThread").start();
        //
        // try {
        //     TimeUnit.SECONDS.sleep(4);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        // System.out.println(Thread.currentThread().getName() + "\t number:" + number);

        new Thread(()->{
            resource.tryOptimisticRead();
        },"readThread").start();
        // 读过程写可以介入
        // try {
        //     TimeUnit.SECONDS.sleep(2);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        // 6s
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t ----come in");
            resource.write();
        },"writeThread").start();
    }
}
