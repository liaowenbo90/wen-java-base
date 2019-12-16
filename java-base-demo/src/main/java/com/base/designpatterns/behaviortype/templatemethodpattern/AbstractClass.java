package com.base.designpatterns.behaviortype.templatemethodpattern;

/**
 * @author liaowb
 * @date 2019-0-1-01-22
 * 抽象角色
 * 抽象模板角色定义了unlock和ride两个使用单车的基本方法，
 * 还有一个钩子方法，用来控制模板方法逻辑顺序，核心是use模板方法，用final修饰，该方法完成对基本方法调度
 */
public abstract class AbstractClass {

    protected boolean inNeedUnlock = true;// 默认需要开锁
    /**
     * 基本方法，子类需要实现
     */
    protected abstract void unlock();
    /**
     * 基本方法，子类需要实现
     */
    protected abstract void ride();
    /**
     * 钩子方法，子类可实现
     */
    protected  void isNeedUnlock(boolean isNeedUnlock){
        this.inNeedUnlock = isNeedUnlock;
    }
    /**
     * 模板方法，负责调度基本方法类，子类不可实现
     */
    public final void use(){
        if (inNeedUnlock) {
            unlock();
        }else {
            System.out.println("=====锁坏了，不用解锁");
        }
            ride();
    }
}
