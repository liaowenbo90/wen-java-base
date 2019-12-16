package com.base.designpatterns.behaviortype.commandpattern;

/**
 * 抽象类 ,类中对需要执行的命令进行声明 ，一般对外公布execute方法来执行
 * @author liaowb
 * @date 2019-03-12
 */
public abstract class Command {

    public abstract void execute();
}
