package com.base.designpatterns.behaviortype.visitorpattern;

/**
 * @author liaowb
 * @date 2019-03-13
 */
public class ConcreteElement2 extends Element {

    @Override
    public void accept(Ivisitor ivisitor) {
        ivisitor.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("这是元素2");
    }
}
