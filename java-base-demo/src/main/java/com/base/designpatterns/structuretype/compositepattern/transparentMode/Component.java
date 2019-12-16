package com.base.designpatterns.structuretype.compositepattern.transparentMode;

import java.util.List;

/**
 * @author liaowb
 * @date 2019-01-15
 * ①抽象构件
 */
public abstract class Component {

    //个体和整体都具有
    public void operation(){
        //编写业务
        System.out.println("编写业务");
    }
    //增加一个叶子构件或树枝构件
    public abstract void add(Component component);
    //删除一个叶子构件或树枝构件
    public abstract void remove(Component component);
    //获得分支下的所有叶子构件和树枝构件
    public abstract List<Component> getChildren();


}
