package com.plume.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //getMethod

        //获取class字节码文件对象
        Class<?> clazz = Class.forName("com.plume.reflect.Student4");

        //获取所有方法对象(包含父类中的公共方法)
        // Method[] methods = clazz.getMethods();
        // for (Method method : methods) {
        //     System.out.println(method);
        // }
        //获取所有方法对象(不包含父类中的公共方法)但有可用获取本类私有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取单个方法  方法名,参数类型
        System.out.println("获取单个方法eat");
        Method eat = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(eat);

        // 获取方法修饰符
        System.out.println("获取方法修饰符eat");
        int modifiers = eat.getModifiers();
        System.out.println(modifiers);

        //获取方法的名字
        System.out.println("获取方法的名字");
        String name = eat.getName();
        System.out.println(name);

        //获取方法的形参
        System.out.println("获取方法的形参");
        for (Parameter parameter : eat.getParameters()) {
            System.out.println(parameter);
        }

        //获取方法抛出异常
        System.out.println("获取方法抛出异常");
        for (Class<?> exceptionType : eat.getExceptionTypes()) {
            System.out.println(exceptionType);
        }

        //方法的运行
        System.out.println("方法的运行");
        Student4 s = new Student4();
        // 参数1:方法的调用者 参数2:方法传入的参数
        eat.setAccessible(true);
        Object result = eat.invoke(s, "肉夹馍");

        //获取方法的返回值
        System.out.println("获取方法的返回值");
        System.out.println(result);


    }
}