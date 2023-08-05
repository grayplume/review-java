package com.plume.utils;

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("亲输入一个整数：");
        int num = scanner.nextInt();
        System.out.println("你输入的整数为："+ num);

        scanner.nextLine(); // 读取换行符，避免影响下一次读取

        System.out.println("亲输入一个字符串：");
        // nextLine() 方法会扫描输入流中的字符，直到遇到行末尾的换行符 \n
        String str = scanner.nextLine();
        System.out.println("你输入的整数为："+ str);

        // 多行数据
        System.out.println("请输入多行数据，以空行结尾：");
        StringBuilder sb = new StringBuilder();
        String line = scanner.nextLine();
        while(!line.isEmpty()){
            sb.append(line).append("\n");
            line = scanner.nextLine(); // 读取下一行
        }
        System.out.println("你输入的文本是： \n" + sb.toString());

        scanner.close();

    }

}
