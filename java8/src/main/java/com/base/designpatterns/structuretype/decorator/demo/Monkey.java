package com.base.designpatterns.structuretype.decorator.demo;

/**
 * @author hasee
 * 具体构件角色“大圣本尊”猢狲类
 */
public class Monkey implements TheGreatestSage {

    @Override
    public void move() {
        //代码
        System.out.println("Monkey Move");
    }
}
