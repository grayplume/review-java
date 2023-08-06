package com.plume.reflect;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.Class这个类里面的静态方法forName
        // Class.forName("类的全类名")： 全类名 = 包名 + 类名
        Class clazz1 = Class.forName("com.plume.reflect.Student");
        // 源代码阶段获取 --- 先把Student加载到内存中，再获取字节码文件的对象
        // clazz 就表示Student这个类的字节码文件对象。
        // 就是当Student.class这个文件加载到内存之后，产生的字节码文件对象


        // 2.通过class属性获取
        // 类名.class  多当作参数传递
        Class clazz2 = Student.class;

        // 因为class文件在硬盘中是唯一的，所以，当这个文件加载到内存之后产生的对象也是唯一的
        System.out.println(clazz1 == clazz2);// true


        // 3.通过Student对象获取字节码文件对象  当已经有了对象时常使用
        Student s = new Student();
        Class clazz3 = s.getClass();
        System.out.println(clazz1 == clazz2);// true
        System.out.println(clazz2 == clazz3);// true

    }
}
