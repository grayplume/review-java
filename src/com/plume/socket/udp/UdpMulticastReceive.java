package com.plume.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UdpMulticastReceive {
    public static void main(String[] args) throws IOException {
        //之前默认是单播,这个是组播

        //创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket(10000);

        // 把当前计算机绑定一个组播地址,表示添加到这一组中.
        ms.joinGroup(InetAddress.getByName("224.0.1.0"));

        //创建datagramPacket数据包对象
        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);

        //接收数据
        ms.receive(dp);

        //解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        String ip = dp.getAddress().getHostAddress();
        String name = dp.getAddress().getHostName();

        //打印数据
        System.out.println("ip为:"+ip+"主机名为:"+name+"的人,发送了数据: "+new String(data,0,len));

        //释放资源
        ms.close();
    }
}
