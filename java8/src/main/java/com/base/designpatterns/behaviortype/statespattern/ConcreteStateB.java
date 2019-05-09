package com.base.designpatterns.behaviortype.statespattern;

/**
 * 具类实现类
 *
 */
public class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {

        System.out.println("ConcreteStateB handle :" + sampleParameter);
    }
}
