package com.plume.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources {
    /**
     * 面对必须要关闭的资源，我们总是应该优先使用 try-with-resources 而不是try-finally。
     * 随之产生的代码更简短，更清晰，产生的异常对我们也更有用。try-with-resources语句让我们更容易编写必须要关闭的资源的代码，
     * 采用try-finally则几乎做不到这点。
     */
    public static void main(String[] args) {

        oldMethods();
        newMethods();



    }

    private static void newMethods() {
        try (Scanner scanner = new Scanner(new File("b.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

    }

    private static void oldMethods() {
        //读取文本文件的内容
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("a.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
