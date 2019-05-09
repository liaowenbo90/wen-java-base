package com.base.designpatterns.structuretype.decorator.demo;

public class Client {

    public static void main(String [] args) {
        TheGreatestSage sage = new Monkey();
        //1写法 单层装饰
        TheGreatestSage brid = new Brid(sage);
        TheGreatestSage fish = new Fish(brid);
            fish.move();
        // 2 双层装饰
        TheGreatestSage fish2 = new Fish(new Brid(sage));
            fish2.move();
    }

}
