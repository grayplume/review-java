package com.plume.map;

import java.util.*;

public class HashMapDemo2 {
    public static void main(String[] args) {
        // 投票
        String[] arr = {"A","B","C","D"};
        ArrayList<String> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 80; i++) {
            int index = random.nextInt(arr.length);
            list.add(arr[index]);
        }

        HashMap<String,Integer> hm = new HashMap<>();

        for (String name : list) {
            if (hm.containsKey(name)){
                // 存在
                Integer count = hm.get(name);
                count++;
                hm.put(name,count);
            }else {
                // 不存在
                hm.put(name,1);
            }
        }

        System.out.println(hm);

        // 求最大值
        int max = 0;

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            Integer count = entry.getValue();
            if (count > max){
                max = count;
            }
        }
        System.out.println(max);

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            Integer count = entry.getValue();
            if (count == max){
                System.out.println(entry.getKey());
            }
        }



    }
}