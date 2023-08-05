package com.plume.generics;

import com.plume.generics.pojos.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsDemo1 {
    public static void main(String[] args) {
        // 没有泛型，集合如何存储数据
        // 如果没有指定类型，默认都是Object
        // 此时可以添加任意类型,坏处是获取数据时,无法使用特有的方法
        // 有了泛型,在添加时就把数据类型进行统一,获取数据时也省的强转
        // 把运行时期的问题提前到了编译期间

        // 扩展:Java中的泛型是伪泛型

        ArrayList list = new ArrayList();

        list.add(111);
        list.add("aaa");
        list.add(new Student("zhangsan",123));

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            // 多态的弊端是不能访问子类的特有功能
            // obj.length();

            System.out.println(obj);
        }
    }
}
