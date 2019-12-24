package com.base.designpatterns.createtype.singleton;

/**
 * @author liaowb
 * @date 2019-01-11
 * 懒汉式单例类.在第一次调用的时候实例化自己
 * 没有考虑线程安全问题，它是线程不安全的
 */
public class Singleton {
    //Singleton通过将构造方法限定为private避免了类在外部被实例化
    private Singleton() {};
    private static Singleton single = null;
    //线程安全做法


       // 3、静态内部类

       // 1、加同步
    public static synchronized Singleton getInstance(){

        if(single == null) {
            // 2、双重检查
            synchronized (Singleton.class) {
                if(single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }




}
