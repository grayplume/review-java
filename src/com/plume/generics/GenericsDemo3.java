package com.plume.generics;

import java.util.ArrayList;

/**
 * 定义一个工具类,添加多个集合的元素
 */
public class GenericsDemo3 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        ListUtil.addAll(list,"aaa","bbb","ccc","ddd","eee");

        System.out.println(list);
    }

}
