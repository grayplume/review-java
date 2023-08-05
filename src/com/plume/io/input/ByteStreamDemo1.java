package com.plume.io.input;


import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo1 {

    public static void main(String[] args) throws IOException {
        //创建对象
        //写出输入
        FileInputStream fis = new FileInputStream("myfile\\a.txt");

        //读出数据
        int b1 = fis.read(); //读取一个数据 读不到返回-1
        System.out.println(b1);
        System.out.println((char) b1); //进行强转


        fis.close();
    }

}