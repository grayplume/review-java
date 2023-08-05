package com.plume.threread.waitAndNotify;

public class ThreadDemo {
    public static void main(String[] args) {
        //生产者和消费者，等待唤醒机制

        Foodie f = new Foodie();
        Cooker c = new Cooker();

        f.start();
        c.start();
    }
}
