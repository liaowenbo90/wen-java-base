package com.base.designpatterns.behaviortype.Iterativesubpattern;

/**
 * 迭代器角色
 * 定义获取 第一个、前一个、后一个及是否有一下个节点
 */
public interface Iterator {

    public Object first();

    public Object previous();

    public Object next();

    public boolean hasNext();



}
