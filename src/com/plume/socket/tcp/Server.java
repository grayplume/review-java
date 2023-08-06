package com.plume.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //TCP协议 接收数据

        //1.创建ServerSocket对象
        ServerSocket ss = new ServerSocket(10001);

        //2.监听客户端连接
        Socket socket = ss.accept();

        //3.从连接通道中获取输入流读取数据
        InputStream is = socket.getInputStream();//字节流
        InputStreamReader isr = new InputStreamReader(is);//字符流 解决中文乱码
        BufferedReader bf = new BufferedReader(isr); //缓冲流 提高效率



        int b;
        while((b = isr.read()) != -1){
            System.out.print((char) b);
        }

        //4.释放资源
        socket.close();
        ss.close();

    }
}
