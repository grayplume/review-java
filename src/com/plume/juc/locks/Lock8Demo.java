package com.plume.juc.locks;

import java.util.concurrent.TimeUnit;

class Phone{
    public synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----sendEmail");
    }
    public synchronized void sendSMS(){
        System.out.println("----sendSMS");
    }
    public void hello(){
        System.out.println("----hello");
    }
}

/**
 * 谈谈对多线程锁的理解，8锁案例说明
 * 1.标准访问有ab两个线程，先打印邮件还是短信？ 先邮件
 * 2.sendEmail方法暂停三秒后呢？  还是邮件
 * [一个对象里面如果有多个synchronized方法,只要有一个线程调用synchronized方法,
 * 其他线程只能等待,锁的是当前对象this,其他线程都不能进入当前对象的其他synchronized方法]
 * 3.添加一个普通的hello方法，先打印邮件还是hello？ hello
 * 4.有两部手机先打印邮件还是短信？  短信
 * [加入普通方法与同步锁无关;换成两个对象后不是同一把锁了]
 * 5.有两个静态同步方法,有1部手机,请问先打印邮件还是短信? 邮件
 * 6.有两个静态同步方法,有2部手机,请问先打印邮件还是短信? 邮件
 * [对于普通同步方法,锁的是当前实例对象,通常指this;对于静态同步方法,锁的是当前类的Class对象;对于同步方法块,锁的是括号内对象]
 * 7.有1个静态同步方法,有1个普通同步方法,有1部手机,请问先打印邮件还是短信? 短信
 * 8.有1个静态同步方法,有1个普通同步方法,有2部手机,请问先打印邮件还是短信? 短信
 * [非静态的同步方法,同步监视器是this;静态的同步方法,同步监视器是类本身]
 *
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            phone.sendEmail();
        },"a").start();

        // 暂停毫秒保证a线程先启动
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            phone.sendSMS();
            // phone.hello();
            // phone2.sendSMS();
        },"b").start();
    }


}
