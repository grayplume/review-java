package com.plume.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo2 {
    public static void main(String[] args) {

        TreeMap<Student, String> tm = new TreeMap<>();

        Student s1 = new Student("林青霞", 30);
        Student s2 = new Student("张曼玉", 35);
        Student s3 = new Student("王祖贤", 33);
        Student s4 = new Student("王祖贤", 33);

        tm.put(s1,"江苏");
        tm.put(s2,"广州");
        tm.put(s3,"西安");
        tm.put(s4,"武汉");

        System.out.println(tm);

    }
}
