package com.plume.juc.tl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 必须回收自定义的ThreadLocal变量，尤其在线程池的场景下，线程经常会被复用，
 * 如果不清理自定义的ThreadLocal变量，可能导致内存泄漏。尽量使用try-finally块进行回收。
 */

class MyData {
    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);

    public void add() {
        threadLocalField.set(threadLocalField.get() + 1);
    }
}

public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.submit(() -> {
                    try {
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName() +
                                " beforeInt:" + beforeInt + " afterInt:" + afterInt);
                    } finally {
                        myData.threadLocalField.remove();
                    }
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }
}
