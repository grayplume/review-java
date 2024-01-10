package com.plume.juc.objectHead;

public class ObjectHeadDemo {
    public static void main(String[] args) {
        Object o = new Object();  //new一个对象多少内存?  16字节
        System.out.println(o.hashCode());//这个hashcode记录在哪里?
        synchronized (o){//

        }
        System.gc();//

        Customber c1 = new Customber();
    }
}

class Customber {  // 只有一个对象头的实例对象
    // 实例填充数据
    int id;
    String customberName;
}
