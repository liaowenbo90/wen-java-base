package com.base.designpatterns.structuretype.decorator.demo2;

/**
 * 定义装饰者
 * @author liaowb
 * @date 2019-03-14
 */
public class Decorator implements Human {

    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        this.human.wearClothes();
    }

    @Override
    public void walkTowhere() {
        human.walkTowhere();
    }
}
