package com.base.designpatterns.behaviortype.visitorpattern;

/**
 * 抽角元素类
 * @author liaowb
 * @date 2019-03-13
 */
public abstract class Element {

    public abstract void accept(Ivisitor ivisitor);
    public abstract void doSomething();
}
