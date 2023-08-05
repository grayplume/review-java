package com.plume.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress getByName()  确定主机名称的IP地址
        //getHostName()  获取IP地址的主机名
        //getHostAddress()  返回文本中IP地址字符串

        InetAddress address = InetAddress.getByName("DESKTOP-6FGDGU7");
        System.out.println(address);

        String name = address.getHostName();
        System.out.println(name);

        String ip = address.getHostAddress();
        System.out.println(ip);

    }
}
