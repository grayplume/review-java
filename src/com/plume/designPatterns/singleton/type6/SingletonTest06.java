package com.plume.designPatterns.singleton.type6;

public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println("使用静态内部类,单例模式");
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode():"+instance.hashCode());
        System.out.println("instance1.hashCode():"+instance1.hashCode());
    }
}

// 静态内部类
/**
 * 采用类装载机制,保证初始化实例只有一个线程
 * 静态内部类在Singleton类装载时不会立即实例化
 * 类的静态属性只会在第一次加载类时初始化,保证线程安全性,效率高
 * 推荐使用
 */
class Singleton{
    // 1.构造器私有化,外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象实例,volatile防止指令重排和可见性
    private static volatile Singleton instance;

    // 静态内部类,包含一个静态属性,当程序中有代码试图访问静态内部类的静态成员,会触发静态内部类的加载。
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3.创建一个共有的静态方法,当使用该方法时,才去创建instance
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}