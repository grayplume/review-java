package com.plume.threread.method;

public class ThreadDemo4 {
    public static void main(String[] args) {
        /*
         * yield   出让线程/礼让线程
         * */
        MyThread3 t1 = new MyThread3();
        MyThread3 t2 = new MyThread3();

        t1.setName("AAA");
        t2.setName("BBB");

        t1.start();
        t2.start();
    }
}
