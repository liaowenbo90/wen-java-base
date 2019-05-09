package com.base.designpatterns.behaviortype.mediationpattern;

/**
 * 同事类
 */
public abstract class AbstractConlleague {

    protected int number;
    // 抽象方法，修改数字是同时修改关联对象
    public abstract void setNumber(int number, AbstractMediator abstractMediator);

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
