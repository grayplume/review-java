package com.plume.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {

    public static void main(String[] args) throws IOException {
        //文件拷贝
        FileInputStream fis = new FileInputStream("b.txt");
        FileOutputStream fos = new FileOutputStream("myfile\\copy.txt");

        //边读边写
        int b;
        while ((b = fis.read()) != -1){
            fos.write(b);
        }

        //释放资源，先开的最后关闭
        fos.close();
        fis.close();
    }

}