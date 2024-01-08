package com.plume.juc.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

class BankAccount {
    // 资源类
    String bankName = "CCB";
    public volatile int money = 0;
    // int money = 0;
    public void add(){
        money++;
    }
    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater =
            AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");
    // 不使用synchronized
    public void transMoney(BankAccount bankAccount){
        fieldUpdater.getAndIncrement(bankAccount);
    }
    // public synchronized void add(){
    //     money++;
    // }
}

/**
 * 以一种线程安全的方式操作非线程安全对象的某些字段
 * 10个线程、转账1000、不使用synchronized
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try{
                    for (int j = 0; j < 1000; j++) {
                        // bankAccount.add();
                        bankAccount.transMoney(bankAccount);
                    }
                }finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"result: "+bankAccount.money);


    }
}
