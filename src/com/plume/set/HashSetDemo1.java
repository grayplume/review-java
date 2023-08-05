package com.plume.set;

import java.util.HashSet;

public class HashSetDemo1 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("zhangsan", 23);

        HashSet<Student> hs = new HashSet<>();

        System.out.println(hs.add(s1));
        System.out.println(hs.add(s2));
        System.out.println(hs.add(s3));
        System.out.println(hs.add(s4));

        System.out.println(hs);

        // 结果为4个，因为没有重写hashcode，因为对象的地址不一样，需要重写hashcode。
    }
}
