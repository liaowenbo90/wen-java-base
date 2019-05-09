package com.base.designpatterns.structuretype.compositepattern.safeMode;

/**
 * @author liaowb
 * @date 2019-01-15
 * 1、抽象构件
 */
public abstract class Component {

    //个体和整体都具有的共享
    public void operation() {
        // 编写业务逻辑
        System.out.println("编写业务逻辑");
    };

}
