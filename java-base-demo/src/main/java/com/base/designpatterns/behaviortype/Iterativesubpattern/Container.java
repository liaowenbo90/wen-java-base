package com.base.designpatterns.behaviortype.Iterativesubpattern;

/**
 * @author liaowb
 * @date 2019-02-21
 * 容器定义,定义了两个抽象方法，用来设置具体迭代实现以及注入容器的元素
 */
public abstract class Container {

    public abstract Iterator iterator();

    public abstract void put(Object obj);


}
