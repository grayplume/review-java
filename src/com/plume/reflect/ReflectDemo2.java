package com.plume.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1.获得整体（class字节码文件对象）
        Class clazz = Class.forName("com.plume.reflect.Student");


        // 2.获取构造方法对象
        // 获取所有构造方法（public）
        Constructor[] constructors1 = clazz.getConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor);
        }

        System.out.println("=======================");

        // 获取所有构造（带私有的）
        Constructor[] constructors2 = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }
        System.out.println("=======================");

        // 获取指定的空参构造
        Constructor con1 = clazz.getConstructor();
        System.out.println(con1);

        Constructor con2 = clazz.getDeclaredConstructor(String.class,int.class); //不加Declared不能获得私有
        System.out.println(con2);

        System.out.println("=======================");


        // 获取指定的构造(所有构造都可以获取到，包括public包括private)
        Constructor con3 = clazz.getDeclaredConstructor();
        System.out.println(con3);
        // 了解 System.out.println(con3 == con1);
        // 每一次获取构造方法对象的时候，都会新new一个。

        Constructor con4 = clazz.getDeclaredConstructor(String.class);
        System.out.println(con4);

        //临时取消权限校验
        con2.setAccessible(true);
        Object stu = con2.newInstance("张三", 23);
        System.out.println(stu);
    }
}