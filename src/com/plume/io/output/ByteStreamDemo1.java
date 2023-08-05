package com.plume.io.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1{

    public static void main(String[] args) throws IOException {
        //创建对象
        //写出输出流
        FileOutputStream fos = new FileOutputStream("myfile\\a.txt");

        //写出数据
        fos.write(97);  //ASCII

        fos.close();

    }

}