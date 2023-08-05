package com.plume.map;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo1 {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("a",123);
        lhm.put("a",111);
        lhm.put("b",456);
        lhm.put("c",789);

        System.out.println(lhm);

    }
}
