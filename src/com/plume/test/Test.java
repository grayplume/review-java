package com.plume.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }
}
public class Test {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        // properties.setProperty("width","1145");
        // properties.setProperty("high","1312");
        //
        // FileOutputStream outputStream = new FileOutputStream("test.properties");
        // properties.store(outputStream,"Program Properties");

        FileInputStream inputStream = new FileInputStream("test.properties");

        properties.load(inputStream);

        System.out.println(properties.getProperty("high"));

        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));

    }
}