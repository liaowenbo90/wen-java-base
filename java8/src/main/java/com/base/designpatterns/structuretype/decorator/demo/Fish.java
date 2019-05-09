package com.base.designpatterns.structuretype.decorator.demo;

/**
 * @author hasee
 * 具体装饰角色“鱼儿”
 */
public class Fish extends Change {

    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        //代码
        System.out.println("Fish move");
    }


}
