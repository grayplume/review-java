package com.plume.designPatterns.singleton.type4;

public class SingletonTest04 {
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
 * 加入同步代码,解决线程安全问题
 * 但是效率大大降低,每一次都要进行同步
 * 不推荐使用
 */
class Singleton{
    // 1.构造器私有化,外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象实例
    private static Singleton instance;

    // 3.创建一个共有的静态方法,当使用该方法时,才去创建instance,加入同步代码,解决线程安全问题
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}