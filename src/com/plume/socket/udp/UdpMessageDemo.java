package com.plume.socket.udp;

import java.io.IOException;
import java.net.*;

public class UdpMessageDemo {
    public static void main(String[] args) throws IOException {
        //发送数据

        //1.创建DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();

        //2.数据打包
        String str = "你好啊!";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        //3.发送
        ds.send(dp);

        //4.释放资源
        ds.close();
    }
}
