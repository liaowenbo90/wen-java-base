package com.base.designpatterns.createtype.singleton;

/**
 * 饿汉式单例，在类初始化时，已经自行实例化了
 */
public class Singleton1 {
    private Singleton1 (){};

    private static final Singleton1 single =  new Singleton1();

    //静态工厂方法
    public static Singleton1 getInstance() {
        return single;
    }
}
