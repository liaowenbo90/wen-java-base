package com.base.designpatterns.structuretype.flyweightpattern;

import java.util.Hashtable;

/**
 * 享元工厂
 */
public class FlyweightFactory {

    private Hashtable flyweights = new Hashtable();

    //获取flyweight实例对象，如果实例不存在就构建，存在直接返回
    public Flyweight getFlyweight(String key) {
        if(flyweights.get(key) == null) {
            flyweights.put(key,new ConcreteFlyweight());
        }
        return (Flyweight) flyweights.get(key);
    }
}
