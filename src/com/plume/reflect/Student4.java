package com.plume.reflect;

import java.io.IOException;

public class Student4 {
    private String name;

    private int age;

    public Student4() {
    }

    public Student4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    private String eat(String something) throws IOException,NullPointerException {
        System.out.println("在吃"+something);
        return "奥力给";
    }

    @Override
    public String toString() {
        return "Student4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
