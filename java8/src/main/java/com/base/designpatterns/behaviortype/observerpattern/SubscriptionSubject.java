package com.base.designpatterns.behaviortype.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowb
 *
 * 具体被观察者 concreteSubject
 * 微信公众号是具体主题（具体被观察者），里面存储了订阅该公众号的微信用户，并实现了抽象主题中的方法：
 */
public class SubscriptionSubject implements Subject {

    //存储订阅公众号和微信用户
    private List<Observer> weixinUserList = new ArrayList<Observer>();


    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}
