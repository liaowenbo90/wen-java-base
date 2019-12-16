package com.base.designpatterns.structuretype.decorator.demo2;

public class Person implements Human {

    @Override
    public void wearClothes() {
        System.out.println("穿什么尼。。");
    }

    @Override
    public void walkTowhere() {
        System.out.println("去哪里尼。。");
    }


}
