package com.plume.jvm;

import java.util.ArrayList;

public class GC_Demo01 {
    // 分代垃圾回收
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws InterruptedException {
        ArrayList<byte[]> list = new ArrayList<>();
        // list.add(new byte[_7MB]);
        // list.add(new byte[_512KB]);
        // list.add(new byte[_512KB]);

        // 直接晋升老年代不进行GC
        // list.add(new byte[_8MB]);

        // OOM
        // list.add(new byte[_8MB]);
        // list.add(new byte[_8MB]);

        // 子线程中OOM不会影响主线程
        // new Thread(()->{
        //     ArrayList<byte[]> list2 = new ArrayList<>();
        //     list2.add(new byte[_8MB]);
        //     list2.add(new byte[_8MB]);
        // }).start();
        // System.out.println("sleep...");
        // Thread.sleep(1000L);
    }
}
