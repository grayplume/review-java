package com.plume.designPatterns.singleton.type5;

public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println("懒汉式,加入同步代码,线程安全");
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode():"+instance.hashCode());
        System.out.println("instance1.hashCode():"+instance1.hashCode());
    }
}

// 懒汉式(线程安全,同步方法)
/**
 * 加入双重检查代码,解决线程安全和懒加载问题,同时保证了效率
 * 推荐
 */
class Singleton{
    // 1.构造器私有化,外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象实例,volatile防止指令重排和可见性
    private static volatile Singleton instance;

    // 3.创建一个共有的静态方法,当使用该方法时,才去创建instance,加入同步代码,解决线程安全问题
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}