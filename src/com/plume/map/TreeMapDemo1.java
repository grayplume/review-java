package com.plume.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo1 {
    public static void main(String[] args) {
        TreeMap<Integer,String> tm = new TreeMap<>();

        tm.put(1,"aaa");
        tm.put(4,"ddd");
        tm.put(5,"eee");
        tm.put(2,"bbb");
        tm.put(3,"ccc");

        System.out.println(tm);
        // 会自动按照键值升序排序
        System.out.println("=====================");

        TreeMap<Integer,String> tm2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        tm2.put(1,"aaa");
        tm2.put(4,"ddd");
        tm2.put(5,"eee");
        tm2.put(2,"bbb");
        tm2.put(3,"ccc");

        System.out.println(tm2);
        // 重写Comparator 键值降序排序

    }
}
