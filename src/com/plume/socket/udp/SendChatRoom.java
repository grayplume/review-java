package com.plume.socket.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendChatRoom {
    public static void main(String[] args) throws IOException {
        //1.创建对象
        DatagramSocket ds = new DatagramSocket();
        //2.打包数据
        Scanner sc = new Scanner(System.in);
       while (true){
           System.out.println("请输入:");
           String str = sc.nextLine();
           if ("886".equals(str)){
               break;
           }
           byte[] bytes = str.getBytes();

           InetAddress address = InetAddress.getByName("127.0.0.1");
           int port = 10086;

           DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

           //3.发送数据
           ds.send(dp);
       }

        //4.释放资源
        ds.close();

    }

}
