package com.base.designpatterns.behaviortype.visitorpattern;

/**
 * 抽象访问者类
 * @author liaowb
 * @date 2019-03-13
 */
public  interface Ivisitor {

    public void visit(ConcreteElement1 el1);

    public void visit(ConcreteElement2 el2);
}
