package com.base.designpatterns.structuretype.decorator.demo;

/**
 * @author hasee
 * 抽象装饰角色“七十二变”
 */
public class Change implements TheGreatestSage {

    private TheGreatestSage sage;

    public Change (TheGreatestSage sage) {
        this.sage = sage;
    }

    @Override
    public void move() {

        //代码
        sage.move();

    }
}
