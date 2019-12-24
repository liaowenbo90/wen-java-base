package com.base.designpatterns.structuretype.flyweightpattern;

/**
 * 客户端测试
 */
public class Client {

    public static void main(String [] agrs) {
        int extrinsicstate = 2;//外部状态
        FlyweightFactory flyweightFactory = new FlyweightFactory();

        Flyweight flyweightA = flyweightFactory.getFlyweight("instanceA");
        flyweightA.operation(extrinsicstate);

        Flyweight flyweightB =  flyweightFactory.getFlyweight("instanceB");
        flyweightB.operation(extrinsicstate);

    }
}
