package com.plume.designPatterns.singleton.type3;

public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println("懒汉式,线程不安全");
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode():"+instance.hashCode());
        System.out.println("instance1.hashCode():"+instance1.hashCode());
    }
}

// 懒汉式(线程不安全)
/**
 * 起到了Lazy Loading效果,但是只能在单线程下使用;(当一个线程进入if语句尚未创建instance,另一个线程也进入,便会产生多个实例)
 * 实际不要使用这种方式
 */
class Singleton{
    // 1.构造器私有化,外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象实例
    private static Singleton instance;

    // 3.创建一个共有的静态方法,当使用该方法时,才去创建instance
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}