package com.base.designpatterns.structuretype.flyweightpattern;

/**
 * 非共享具体享元类
 */
public class UnshareConcreteFlyweight extends Flyweight {

    @Override
    public void operation(int extrinsicsstate) {
        System.out.println("不共享的具体Flyweight:" + extrinsicsstate);

    }


}
