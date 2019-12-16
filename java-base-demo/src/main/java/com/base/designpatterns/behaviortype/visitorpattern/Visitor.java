package com.base.designpatterns.behaviortype.visitorpattern;

/**
 * 访问者类
 *
 * @author liaowb
 * @date 2019-03-13
 */
public class Visitor implements Ivisitor {

    @Override
    public void visit(ConcreteElement1 el1) {
        el1.doSomething();

    }

    @Override
    public void visit(ConcreteElement2 el2) {
        el2.doSomething();
    }
}
