package com.base.designpatterns.structuretype.decorator.demo2;

public class Decorator_zero extends Decorator {


    public Decorator_zero(Human human) {
        super(human);
    }

    public  void goHome(){
        System.out.println("进房子");
    }

    public void findMap(){
        System.out.println("书房找找Map..");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    @Override
    public void walkTowhere() {
        super.walkTowhere();
        findMap();
    }


}
