package com.base.designpatterns.behaviortype.statespattern;

/**
 * 抽象状态类
 * @author liaowb
 * @date 2019-03-13
 */
public interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);

}
