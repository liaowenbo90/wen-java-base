package com.base.designpatterns.structuretype.bridgepattern;

/**
 * @author liaowb
 * @date 2019-01-14
 * 3 Abstraction（城市抽象类，这里包含了一个Implementor）
 */
public abstract class AbstractCityArea {

    protected Restaurant restaurant;

    public AbstractCityArea (Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * 评论 味道
     */
    public abstract void commentTaste();

}
