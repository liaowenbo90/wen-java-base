package com.base.designpatterns.structuretype.bridgepattern;

/**
 * @author liaowb
 * @date 2019-01-14
 * 4 RefinedAbstraction（具体的城市类）
 */
public class ShanghaiRestaurant extends AbstractCityArea {


    public ShanghaiRestaurant(Restaurant restaurant) {
        super(restaurant);
    }

    @Override
    public void commentTaste() {
        System.out.println("上海的" + this.restaurant.taste());
    }
}

