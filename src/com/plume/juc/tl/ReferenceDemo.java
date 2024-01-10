package com.plume.juc.tl;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class MyObject {
    // 这个方法一般不用复写
    @Override
    protected void finalize() throws Throwable {
        System.out.println("MyObject被回收了");
        super.finalize();
    }
}

public class ReferenceDemo {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, referenceQueue);
        System.out.println("----always return null: " + phantomReference.get());

        ArrayList<byte[]> list = new ArrayList<>();
        new Thread(() -> {
            while (true) {
                list.add(new byte[1024 * 1024]);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(phantomReference.get()+"\t list add ok");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                Reference<? extends MyObject> reference = referenceQueue.poll();
                if(reference != null){
                    System.out.println(reference.get()+"\t list remove ok");
                    break;
                }
            }
        }, "t2").start();


    }

    private static void weakReference() {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("----weakReference gc before: " + weakReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----weakReference gc after: " + weakReference.get());
    }

    private static void softReference() {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println("----softReference gc before: " + softReference.get());

        System.gc();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 内存够用不回收
        // -Xms10m -Xmx10m
        System.out.println("----softReference gc after: " + softReference.get());
        try {
            byte[] bytes = new byte[20 * 1024 * 1024]; // 20mb对象
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("----gc after 内存不够用时: " + softReference.get());

        }
    }

    private static void strongReference() {
        MyObject myObject = new MyObject();
        System.out.println("gc before: " + myObject);

        myObject = null; // 没有被引用了
        System.gc();  // 人工GC

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("gc after: " + myObject);
    }
}
