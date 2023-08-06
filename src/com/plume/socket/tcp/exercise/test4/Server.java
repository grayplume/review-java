package com.plume.socket.tcp.exercise.test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        // 客户端：将本地文件上传到服务器。接收服务器的反馈。
        // 服务器：接收客户端上传的文件，上传完毕之后给出反馈。

        // 创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                16,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 1.创建对象并绑定端口
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            // 2.等待客户端来连接
            Socket socket = ss.accept();

            // 开启一条线程
            // 一个用户就对应服务端的一条线程
            // new Thread(new MyRunnable(socket)).start();\
            pool.submit(new MyRunnable(socket));
        }


    }
}


