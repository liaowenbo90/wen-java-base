package com.base.designpatterns.structuretype.flyweightpattern;

public class ConcreteFlyweight extends Flyweight {

    @Override
    public void operation(int extrinsicsstate) {

        System.out.println("具体Flyweight:" + extrinsicsstate);

    }
}
