package com.plume.generics;

import java.util.ArrayList;

public class ListUtil {
    private ListUtil(){}

    // 类中定义一个静态方法addAll,用来添加多个集合的元素

    /**
     *
     * @param list 要添加的集合
     * @param <E> 类型
     */
    /*public static<E> void addAll(ArrayList<E> list,E e1,E e2,E e3,E e4){
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
    }*/
    public static<E> void addAll(ArrayList<E> list,E...e){
        for (E element : e) {
            list.add(element);
        }
    }

    public void show(){
        System.out.println("----------");
    }
}
