package com.base.designpatterns.structuretype.bridgepattern;

/**
 * @author liaowb
 * 4 RefinedAbstraction（具体的城市类）
 */
public class NanjingRestaurant extends AbstractCityArea {


    public NanjingRestaurant(Restaurant restaurant) {
        super(restaurant);
    }

    @Override
    public void commentTaste() {
        System.out.println("南京的" + super.restaurant.taste());
    }
}
