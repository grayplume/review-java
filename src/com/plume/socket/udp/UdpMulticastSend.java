package com.plume.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UdpMulticastSend {
    public static void main(String[] args) throws IOException {
        //之前默认是单播,这个是组播

        //创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket();
        //创建DatagramPacket对象
        String s = "hello 组播";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        int port = 10000;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        // 调用对象的方法发送数据(在单播中,这里是发给指定IP的电脑但是在组播当中,这里是发给组播地址)
        ms.send(dp);
        // 4. 释放资源
        ms.close();
    }
}
