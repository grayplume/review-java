package com.plume.juc.volatiles;


import java.util.concurrent.TimeUnit;

class MyNumber{
    int number;

    public synchronized void addPlusPlus(){// 不加锁就不能保证原子性
        number++;
    }
}
public class VolatileNoAtomicDemo {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    myNumber.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myNumber.number);
    }
}
