package com.plume.map;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapDemo3 {
    public static void main(String[] args) {

        String s = "aababcabcdbcde";

        TreeMap<Character, Integer> tm = new TreeMap<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // System.out.println(c);
            if (tm.containsKey(c)){
                // 存在
                Integer count = tm.get(c);
                count++;
                tm.put(c,count);
            }else {
                // 不存在
                tm.put(c,1);
            }
        }

        StringBuilder sb = new StringBuilder();

        tm.forEach((key,value) -> sb.append(key).append("(").append(value).append(")"));
        System.out.println(sb);
    }
}
