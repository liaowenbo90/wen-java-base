package com.base.designpatterns.behaviortype.observerpattern;

/**
 * @author liaowb
 * @date 2019-01-24
 * 具体观察者
 * concreteObserver
 */
public class WeixinUser implements Observer {

    private String name;

    public WeixinUser(){};
    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
