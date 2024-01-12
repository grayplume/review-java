package com.plume.juc.rwLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级：遵循获取写锁->再获取读锁->再释放写锁的次序，写锁能够降级成为读锁。如果一个线程占有了写锁，在不释放写锁的情况下，它还能占有读锁，即写锁降级为读锁。
 * 锁降级是为了让当前线程感知到数据的变化，目的是保证数据的可见性。
 */
public class LockDownGradingDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        // 正常AB两个线程
        // A
        /*writeLock.lock();
        System.out.println("----写入");
        writeLock.unlock();

        // B
        readLock.lock();
        System.out.println("----读取");
        readLock.unlock();*/

        //本例 only one 同一线程 降级
        /*writeLock.lock();
        System.out.println("----写入");
        readLock.lock();
        System.out.println("----读取");
        writeLock.unlock();
        readLock.unlock();*/

        // 读没有完成时写锁无法获得锁,这是悲观锁的策略 不可以升级
        readLock.lock();
        System.out.println("----读取");
        writeLock.lock();
        System.out.println("----写入");
        writeLock.unlock();
        readLock.unlock();


    }
}
