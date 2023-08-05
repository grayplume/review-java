package com.plume.generics;

import java.util.Arrays;

/**
 * 编写一个类,不确定类型,就可以定义为泛型类
 *
 * @param <E> 类型
 */
public class MyArrayList<E> {

    Object[] obj = new Object[10];
    int size;


    public boolean add(E e) {
        obj[size] = e;
        size++;
        return true;
    }

    public E get(int index) {
        return (E) obj[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
