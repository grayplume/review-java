package com.plume.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //TCP协议  发送数据

        //1.创建socket对象  三次握手保证连接建立
        Socket socket = new Socket("127.0.0.1", 10001);

        //2.可以从连接通道获取输出流
        OutputStream os = socket.getOutputStream();
        //写出数据
        os.write("你好你好".getBytes());

        //3.释放资源  四次挥手,确保连接躲开并且保证数据已经处理完毕
        os.close();
        socket.close();
    }
}
