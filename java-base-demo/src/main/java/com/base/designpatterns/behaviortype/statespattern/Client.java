package com.base.designpatterns.behaviortype.statespattern;

/**
 * 客户端类
 * @author liaowb
 */
public class Client {

    public static void main(String[] args) {

        //创建状态
        State state = new ConcreteStateB();

        //创建环境
        Context context  = new Context();

        //将状态设置环境中
        context.setState(state);

        //请求
        context.request("tests");


    }
}
