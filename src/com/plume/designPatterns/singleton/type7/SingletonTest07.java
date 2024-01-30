package com.plume.designPatterns.singleton.type7;

public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println("使用枚举,单例模式");
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode():"+instance.hashCode());
        System.out.println("instance1.hashCode():"+instance1.hashCode());

        instance.sayOK();
    }
}

// 使用枚举方法
/**
 * 避免多线程同步问题,防止反序列化重新创建新对象
 * 推荐使用
 */
enum Singleton{
    INSTANCE;  // 属性
    public void sayOK(){
        System.out.println("ok~");
    }
}