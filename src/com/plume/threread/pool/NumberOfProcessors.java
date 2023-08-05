package com.plume.threread.pool;

public class NumberOfProcessors {
    public static void main(String[] args) {
        //向Java虚拟机返回可用处理器数目
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }
}
