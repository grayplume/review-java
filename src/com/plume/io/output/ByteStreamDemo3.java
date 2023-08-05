package com.plume.io.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo3 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("myfile\\a.txt");

        //写出数据
        // fos.write(97); //a
        // fos.write(98); //b

        // 批量写出
        byte[] bytes = {97,98,99,100,101}; //abcde
        // fos.write(bytes);
        //指定写出数据
        fos.write(bytes,1,2);

        fos.close();

    }

}