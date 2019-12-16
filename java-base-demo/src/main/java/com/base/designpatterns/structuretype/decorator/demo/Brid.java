package com.base.designpatterns.structuretype.decorator.demo;

/**
 * @author hasee
 * 具体装饰角色“鸟儿”
 */
public class Brid extends Change {


    public Brid(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
       //代码
       System.out.println("Bird Move");

    }
}
