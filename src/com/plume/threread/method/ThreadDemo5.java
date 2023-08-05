package com.plume.threread.method;

public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        /*
         * join  插入线成功/插队线程
         * */
        MyThread4 t1 = new MyThread4();
        t1.setName("AAA");
        t1.start();

        t1.join();//插入

        //执行在main线程中的
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程"+i);
        }

    }
}
