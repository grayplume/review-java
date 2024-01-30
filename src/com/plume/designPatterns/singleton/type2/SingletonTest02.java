package com.plume.designPatterns.singleton.type2;

public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode():"+instance.hashCode());
        System.out.println("instance1.hashCode():"+instance1.hashCode());
    }
}

// 饿汉式(静态代码块)
/**
 * 优点:简单,类加载时就完成了实例化,避免了线程同步问题;
 * 缺点:没有达到Lazy Loading效果,如果从始至终未使用,造成内存浪费;
 */
class Singleton{
    // 1.构造器私有化,外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象实例
    private static Singleton instance;

    // 在静态代码块中创建单例对象
    static {
        instance = new Singleton();
    }

    // 3.创建一个共有的静态方法,返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

}