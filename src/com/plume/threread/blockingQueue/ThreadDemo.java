package com.plume.threread.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        // 创建阻塞队列的对象,容量为 1
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Foodie f = new Foodie(queue);
        Cooker c = new Cooker(queue);

        f.start();
        c.start();

        //打印的 数据是连续打印  打印语句是在锁的外面  对数据没影响
    }
}