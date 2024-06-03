package com.plume.string;

public class PlusMethod {
    // String 类型的变量和常量做“+”运算时发生了什么？
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        // 对于 String str3 = "str" + "ing"; 编译器会给你优化成 String str3 = "string";
        // 引用的值在程序编译期是无法确定的,编译器无法对其进行优化.
        // 如果引用对象被final修饰,编译期编译器知道其是确定的,效果就相当于访问常量,可以进行优化.
        // 如果运行时才知道其值,则无法进行优化

        //  String str4 = new StringBuilder().append(str1).append(str2).toString();
        //  对象引用和+方法实际上都是通过StringBuilder调用append()方法实现的,拼接完成后会调用toString()生成一个String对象.
        //  日常这样会造成重复创建String对象,推荐使用StringBuilder或StringBuffer
    }
}
