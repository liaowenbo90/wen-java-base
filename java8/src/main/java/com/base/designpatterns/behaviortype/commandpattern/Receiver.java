package com.base.designpatterns.behaviortype.commandpattern;

/**
 * 接收者，负责接收命令并且执行命令
 * @author liaowb
 * @date 2019-03-12
 */
public class Receiver {

    public void doSomething(){
        System.out.println("接受者-业务逻辑处理");
    }


}
