package com.plume.io.input;


import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo2 {

    public static void main(String[] args) throws IOException {
        //创建对象
        //写出输入
        FileInputStream fis = new FileInputStream("myfile\\a.txt");

        //循环读出数据
        int data;

        while((data = fis.read()) != -1){
            System.out.print((char) data);
        }

        fis.close();
    }

}