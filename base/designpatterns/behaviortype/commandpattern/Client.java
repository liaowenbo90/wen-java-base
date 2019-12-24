package com.base.designpatterns.behaviortype.commandpattern;

/**
 * 最终的客户端调用类
 * @author liaowb
 * @date 2019-03-12
 */
public class Client {

    public static void main(String [] args){

        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        // 客户端直接执行具体命令方式
        command.execute();

        //客户端通过调用者来执行命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();

    }
}
