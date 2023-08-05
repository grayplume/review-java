package com.plume.utils;

import java.util.Arrays;

public class ArraysDemo1 {
    public static void main(String[] args) {
        // 创建数组  copyOf copyOfRange fill
        // 比较数组  equals hashCode
        // 数组排序  sort
        // 数组检索  binarySearch
        // 数组流转  stream
        // 打印数组  toString
        // 数组转List  asList  注意：返回的是 java.util.Arrays.ArrayList
        // 并不是 java.util.ArrayList，它的长度是固定的，无法进行元素的删除或者添加。
        // 函数式编程入口  setAll parallePrefix


        // 创建数组
        String[] intro = new String[] { "你", "好", "吗", "！" };
        String[] revised = Arrays.copyOf(intro, 3);
        String[] expanded = Arrays.copyOf(intro, 5);
        System.out.println("copyOf:"+Arrays.toString(revised));
        System.out.println("copyOf:"+Arrays.toString(expanded));
        // copyOfRange
        String[] abridgement = Arrays.copyOfRange(intro, 0, 3);
        System.out.println("copyOfRange:"+Arrays.toString(abridgement));

        String[] abridgementExpanded = Arrays.copyOfRange(intro, 0, 6);
        System.out.println("copyOfRange:"+Arrays.toString(abridgementExpanded));

        // fill
        String[] stutter = new String[4];
        Arrays.fill(stutter, "test");
        System.out.println("fill:"+Arrays.toString(stutter));


    }
}
