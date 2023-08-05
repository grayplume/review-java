package com.plume.generics;

public class GenericsDemo4 {
    public static void main(String[] args) {
        /*泛型接口两种使用方式
        *   1.实现类给出具体的类型
        *   2.实现类延续泛型,创建实现类对象时再确定类型
        * */

        MyArrayList2 list = new MyArrayList2();
        list.add("aaa");
        // list.add(111);


        MyArrayList3<String> list2 = new MyArrayList3();
        list2.add("aaa");
    }
}
