package com.plume.set;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo1 {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("zhangsan", 23);

        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();

        System.out.println(linkedHashSet.add(s1));
        System.out.println(linkedHashSet.add(s2));
        System.out.println(linkedHashSet.add(s3));
        System.out.println(linkedHashSet.add(s4));

        System.out.println(linkedHashSet);
        // 有序的捏，按照添加的顺序
    }
}
