package com.plume.io.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamDemo4 {

    public static void main(String[] args) throws IOException {

        //第二个参数打开续写
        FileOutputStream fos = new FileOutputStream("myfile\\a.txt",true);
        //写出数据
        // String str = "woshiyinzei";
        String str = "我是那啥 ";
        byte[] bytes1 = str.getBytes();
        // System.out.println(Arrays.toString(arr));
        fos.write(bytes1);

        //写一个换行符
        String lineFeed = "\r\n";
        byte[] bytes = lineFeed.getBytes();
        fos.write(bytes);

        String str2 = "第二句呦";
        byte[] bytes2 = str2.getBytes();
        fos.write(bytes2);

        String str3 = "续写呦";
        byte[] bytes3 = str3.getBytes();
        fos.write(bytes3);



        fos.close();

    }

}