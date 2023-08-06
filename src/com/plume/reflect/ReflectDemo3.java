package com.plume.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //getFields

        //获取class字节码文件对象
        Class<?> clazz = Class.forName("com.plume.reflect.Student3");
        //获取成员变量
        for (Field field : clazz.getFields()) { //getFields/getDeclaredFields获取全部
            System.out.println(field);
        }
        System.out.println("===============");
        //获取单个成员变量
        System.out.println("获取单个成员变量gender");
        Field gender = clazz.getField("gender");
        System.out.println(gender);
        System.out.println("获取私有成员变量name");
        Field name = clazz.getDeclaredField("name");
        System.out.println(name);
        System.out.println("================");
        //获取权限修饰符
        System.out.println("获取成员变量name的修饰符Modifiers");
        int modifiers = name.getModifiers();
        System.out.println(modifiers);

        System.out.println("获取成员变量name的名字");
        String n = name.getName();
        System.out.println(n);

        System.out.println("获取成员变量name的数据类型");
        Class<?> type = name.getType();
        System.out.println(type);

        System.out.println("获取成员变量name的值");
        Student3 s = new Student3("zhangsan", 23,  "西安");
        name.setAccessible(true);
        Object val = name.get(s);
        System.out.println(val);

        System.out.println("修改成员变量name的值");
        name.set(s,"lisi");
        System.out.println(s);

    }
}