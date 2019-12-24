package com.base.designpatterns.behaviortype.statespattern;

/**
 * 具类实现类
 * @author liaowb
 */
public class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {

        System.out.println("ConcreteStateA handle :" + sampleParameter);
    }
}
