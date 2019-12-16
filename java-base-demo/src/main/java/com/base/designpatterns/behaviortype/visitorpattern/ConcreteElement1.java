package com.base.designpatterns.behaviortype.visitorpattern;

/**
 * 元素类
 * @author liaowb
 * @date 2019-03-13
 */
public class ConcreteElement1 extends Element {

    @Override
    public void accept(Ivisitor ivisitor) {
        ivisitor.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("这是元素1");
    }
}
